#include <vector>
#include <iostream>
#include <unordered_map>
#include <string>
using namespace std;
const int MAX = 1000;
inline int get_key(int i, int j) { return MAX * i + j; }

class WeightedQuickUnionUF {
    int parent[MAX * MAX + MAX + 1];
    int size[MAX * MAX + MAX + 1];

public:
    WeightedQuickUnionUF(const vector<vector<int> > &grid) {
        memset(parent, 0, sizeof(parent));
        memset(size, 0, sizeof(size));

        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid[i].size(); j++) {
                int key = get_key(i, j);
                parent[key] = key;
                size[key] = 1;
            }
        }
    }

    int find(const int key) {
        if (parent[key] != key) {
            parent[key] = find(parent[key]);
        }
        return parent[key];
    }

    void map_union(const int p, const int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
    }

    [[nodiscard]] const int *get_union_map() const {
        return parent;
    }
};

class Solution {
    static int get_left(const vector<vector<int> > &grid, int i, int j) {
        if (j - 1 < 0) return -1;
        return grid[i][j - 1];
    }

    static int get_top(const vector<vector<int> > &grid, int i, int j) {
        if (i - 1 < 0) return -1;
        return grid[i - 1][j];
    }

public:
    int countIslands(vector<vector<int> > &grid, int k) {
        if (grid.empty() || grid[0].empty()) return 0;

        WeightedQuickUnionUF uf(grid);
        unordered_map<int, int> value_map;

        int m = grid.size(), n = grid[0].size();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;

                int key = get_key(i, j);
                value_map[key] = grid[i][j];

                // Union with left
                if (get_left(grid, i, j) > 0) {
                    int left_key = get_key(i, j - 1);
                    uf.map_union(key, left_key);
                }

                // Union with top
                if (get_top(grid, i, j) > 0) {
                    int top_key = get_key(i - 1, j);
                    uf.map_union(key, top_key);
                }
            }
        }

        // Final count
        unordered_map<int, int> result_map;
        for (const auto &[key, _]: value_map) {
            int root = uf.find(key);
            result_map[root] = (result_map[root] + value_map[key]) % 10000000;
        }

        int result = 0;
        for (const auto &[_, total]: result_map) {
            if (total % k == 0) {
                result++;
            }
        }

        return result;
    }
};

int main() {
    Solution s;
    // vector<vector<int> > grid = {{0, 2, 1, 0, 0}, {0, 5, 0, 0, 5}, {0, 0, 1, 0, 0}, {0, 1, 4, 7, 0}, {0, 2, 0, 0, 8}};
    vector<vector<int> > grid = {{0, 0, 0}, {0, 0, 1}, {11, 0, 6}, {0, 10, 2}, {0, 0, 0}, {8, 0, 0}};
    cout << "res===>" << s.countIslands(grid, 19);
}
