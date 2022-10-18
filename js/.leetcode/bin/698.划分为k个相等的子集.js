"use strict";
/*
 * @lc app=leetcode.cn id=698 lang=typescript
 *
 * [698] 划分为k个相等的子集
 */
// @lc code=start
function canPartitionKSubsets(nums, k) {
    if (k == 0) {
        return true;
    }
    nums = nums.sort();
    let sum = 0;
    nums.forEach((item) => {
        sum += item;
    });
    if (sum % k != 0) {
        return false;
    }
    let target = sum / k;
    let groups = Array(k).fill(0);
    let helper = (index) => {
        if (index < 0) {
            return true;
        }
        let v = nums[index];
        for (let i = 0; i < groups.length; i++) {
            if (groups[i] + v <= target) {
                groups[i] += v;
                if (helper(index - 1)) {
                    return true;
                }
                groups[i] -= v;
            }
        }
        return false;
    };
    return helper(nums.length - 1);
}
;
// @lc code=end
// console.log('==>'+canPartitionKSubsets([1,1,1,1,1,1,1,1,1,1],5))
//# sourceMappingURL=698.%E5%88%92%E5%88%86%E4%B8%BAk%E4%B8%AA%E7%9B%B8%E7%AD%89%E7%9A%84%E5%AD%90%E9%9B%86.js.map