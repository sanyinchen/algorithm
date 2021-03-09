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
    var sum = 0;
    nums.forEach(function (item) {
        sum += item;
    });
    if (sum % k != 0) {
        return false;
    }
    var target = sum / k;
    var groups = Array(target);
    var helper = function (index) {
        if (index < 0) {
            return true;
        }
        var v = nums[index];
        for (var i = 0; i < groups.length; i++) {
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
    console.log("groups:" + groups.length);
    groups.forEach(function (item) {
        console.log(item + " ");
    });
    return helper(nums.length - 1);
}
;
// @lc code=end
