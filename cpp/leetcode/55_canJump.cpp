//
// Created by sanyinchen on 7/27/25.
//
#include <common.h>

class Solution {
public:
    bool canJump(vector<int>& nums) {
        vector<int> dp(nums.size(), -1);
        function<bool(int)> can_jump = [&](int i) {
            if (i >= nums.size() - 1) {
                return true;
            }
            if (dp[i] != -1) {
                return static_cast<bool>(dp[i]);
            }
            for (int j = 1; j <= nums[i]; ++j) {
                if (can_jump(i + j)) {
                    dp[i] = 1;
                    return true;
                }
            }
            dp[i] = 0;
            return false;
        };
        return can_jump(0);
    }
};

signed main(int argc, char const* argv[]) {
    Solution s;
    vector<int> nums{2, 3, 1, 1, 4};
    // vector<int> nums{3, 2, 1, 0, 4};
    cout << s.canJump(nums) << endl;
}
