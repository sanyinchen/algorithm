#include <iostream>
#include <vector>
#include <unordered_map>
#include <unordered_set>
#include <climits>
using namespace std;

class Solution {
public:
    int minimumScore(vector<int> &nums, vector<vector<int> > &edges) {
        unordered_map<int, unordered_set<int> > adj;
        for (auto &edge: edges) {
            int u = edge[0], v = edge[1];
            adj[u].insert(v);
            adj[v].insert(u);
        }

        int n = nums.size();
        vector<int> xor_subtree(n), tin(n), tout(n);
        int timer = 0;

        function<void(int, int)> dfs = [&](int u, int parent) {
            tin[u] = ++timer;
            xor_subtree[u] = nums[u];
            for (int v: adj[u]) {
                if (v == parent) continue;
                dfs(v, u);
                xor_subtree[u] ^= xor_subtree[v];
            }
            tout[u] = ++timer;
        };

        dfs(0, -1);
        int totalXor = xor_subtree[0];

        auto isAncestor = [&](int u, int v) {
            return tin[u] <= tin[v] && tout[v] <= tout[u];
        };

        // 使用两个断边模拟两个子树的根（节点）
        function<int(pair<int, int>, pair<int, int>)> get_score = [&](pair<int, int> e1, pair<int, int> e2) {
            // 断边：确定子树根
            int u = (tin[e1.first] > tin[e1.second]) ? e1.first : e1.second;
            int v = (tin[e2.first] > tin[e2.second]) ? e2.first : e2.second;

            int x = xor_subtree[u], y = xor_subtree[v], z;

            if (isAncestor(u, v)) {
                z = totalXor ^ x;
                x ^= y;
            } else if (isAncestor(v, u)) {
                z = totalXor ^ y;
                y ^= x;
            } else {
                z = totalXor ^ x ^ y;
            }

            int mx = max({x, y, z});
            int mn = min({x, y, z});
            return mx - mn;
        };

        int min_score = INT_MAX;
        int m = edges.size();
        for (int i = 0; i < m - 1; i++) {
            for (int j = i + 1; j < m; j++) {
                pair<int, int> e1 = {edges[i][0], edges[i][1]};
                pair<int, int> e2 = {edges[j][0], edges[j][1]};
                min_score = min(min_score, get_score(e1, e2));
            }
        }
        return min_score;
    }
};

int main() {
    Solution s;
    vector<int> nums{1, 5, 5, 4, 11};
    vector<vector<int> > edges{{0, 1}, {1, 2}, {1, 3}, {3, 4}};
    cout << s.minimumScore(nums, edges) << endl; // 输出应为 9
}
