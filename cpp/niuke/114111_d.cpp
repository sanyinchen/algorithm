#include <algorithm>
#include <climits>
#include <cstdio>
#include <functional>
#include <iostream>
#include <unistd.h>
#include <unordered_map>
#include <unordered_set>
#include <vector>
using namespace std;

#define int long long
const long long INF = LONG_LONG_MAX;

signed main() {
    freopen("niuke_input.txt", "r", stdin);
    int t;
    cin >> t;

    while (t--) {
        int n;
        cin >> n;

        unordered_map<int, int> memo;
        unordered_map<int, int> choice; // 记录每个 k 最优选择的段长 len

        function<int(int)> dfs = [&](int k) -> int {
            if (k == 0) return 0;
            if (memo.count(k)) return memo[k];

            int res = INF;

            for (int len = 1;; ++len) {
                int w = len * (len + 1) / 2;
                if (w > k) break;

                int sub = dfs(k - w);
                if (sub != INF) {
                    int total = len + sub + (k - w > 0 ? 1 : 0);
                    if (total < res) {
                        res = total;
                        choice[k] = len;
                    }
                }
            }

            return memo[k] = res;
        };

        dfs(n);

        string result;
        int k = n;
        while (k > 0) {
            int len = choice[k];
            result += string(len, '1');
            k -= len * (len + 1) / 2;
            if (k > 0) result += '0';
        }

        cout << result << endl;
    }

    return 0;
}
