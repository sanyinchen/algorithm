#include <algorithm>
#include <cstdio>
#include <iostream>
#include <unistd.h>
#include <vector>
using namespace std;

using fuck_int_limit = unsigned long long;

class Solution {
public:
    static vector<fuck_int_limit> knapsack(vector<pair<fuck_int_limit, fuck_int_limit>>& nums, fuck_int_limit w) {
        const fuck_int_limit min = (w + 1) / 2;
        vector<fuck_int_limit> res;
        // 1. 先检查是否存在单个重量满足要求
        for (auto& [idx, val] : nums) {
            if (val >= min && val <= w) {
                return {idx};
            }
        }
        fuck_int_limit sum = 0;
        ranges::sort(nums, [](const pair<fuck_int_limit, fuck_int_limit>& a,
                              const pair<fuck_int_limit, fuck_int_limit>& b) {
            return a.second < b.second;
        });
        for (auto& [fst, snd] : nums) {
            sum += snd;
            if (sum > w) {
                sum -= snd;
                break;
            }
            res.push_back(fst);
        }
        if (sum < min) {
            res.clear();
        }
        return res;
    }
};


int main(int argc, char const* argv[]) {
    freopen("cf_input.txt", "r", stdin);
    fuck_int_limit t;
    cin >> t;
    while (t--) {
        fuck_int_limit n, w;
        cin >> n >> w;
        vector<pair<fuck_int_limit, fuck_int_limit>> inputs;
        inputs.reserve(n);
        for (fuck_int_limit i = 0; i < n; ++i) {
            fuck_int_limit val;
            cin >> val;
            inputs.emplace_back(i + 1, val);
        }
        if (vector<fuck_int_limit> res = Solution::knapsack(inputs, w); res.empty()) {
            cout << "-1" << endl;
        }
        else {
            cout << res.size() << endl;
            for (fuck_int_limit i = 0; i < res.size(); ++i) {
                cout << res[i];
                if (i != res.size() - 1) {
                    cout << " ";
                }
                else {
                    cout << endl;
                }
            }
        }
    }
    return 0;
}
