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

# define int long long
const long long INF = LONG_LONG_MAX;

signed main() {
    freopen("niuke_input.txt", "r", stdin);

    int T;
    cin >> T;
    while (T--) {
        int n;
        cin >> n;
        string s;
        cin >> s;
        vector<int> nums;
        for (int i = 0; i < n; i++) {
            nums.push_back(s[i] - '0');
        }
        auto func = [&](int first) -> long long {
            vector<int> diff(n);
            for (int i = 0; i < n; ++i)
                diff[i] = (nums[i]) ^ ((first + i) & 1);

            long long op = 0;
            for (int i = 0; i < n - 1; ++i) {
                if (diff[i]) {
                    ++op;
                    diff[i] ^= 1;
                    diff[i + 1] ^= 1;
                }
            }
            return diff[n - 1] ? INF : op;
        };
        int ans = min(func(0), func(1));
        cout << (ans == INF ? -1 : ans) << '\n';
    }
    return 0;
}
