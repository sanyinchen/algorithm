//
// Created by sanyinchen on 7/27/25.
//
#include <common.h>

class Solution {
public:
    int jump(vector<int>& nums) {
        unordered_map<int, int> mp;
        function<int(int)> jum_func = [&](int index)-> int {
            if (index >= nums.size() - 1) {
                return 0;
            }
            if (mp.find(index) != mp.end()) {
                return mp[index];
            }

            int step = INT_MAX;
            for (int i = 1; i <= nums[index]; i++) {
                if (const int next_index = index + i; next_index < nums.size()) {
                    if (const int next_jump = jum_func(next_index); next_jump != INT_MAX) {
                        step = min(step, next_jump + 1);
                    }
                }
            }
            if (step == INT_MAX) {
                return 0;
            }
            mp[index] = step;
            return step;
        };
        return jum_func(0);
    }
};


// int main(int argc, char const* argv[]) {
//     Solution solution;
//     vector<int> nums({2, 3, 1, 1, 4});
//     cout << solution.jump(nums);
// }
