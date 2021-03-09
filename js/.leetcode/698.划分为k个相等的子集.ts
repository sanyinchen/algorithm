/*
 * @lc app=leetcode.cn id=698 lang=typescript
 *
 * [698] 划分为k个相等的子集
 */

// @lc code=start

function canPartitionKSubsets(nums: number[], k: number): boolean {
    if (k == 0) {
        return true
    }
    nums = nums.sort()
    let sum = 0;
    nums.forEach((item) => {
        sum += item
    })
    if (sum % k != 0) {
        return false
    }
    let target = sum / k
    let groups = Array<number>(k).fill(0)
    let helper = (index: number) => {
        if (index < 0) {
            return true
        }
        let v = nums[index]
        for (let i = 0; i < groups.length; i++) {
            if (groups[i] + v <= target) {
                groups[i] += v
                if (helper(index - 1)) {
                    return true
                }
                groups[i] -= v
            }
        }
        return false
    }
    return  helper(nums.length - 1)
};
// @lc code=end
// console.log('==>'+canPartitionKSubsets([1,1,1,1,1,1,1,1,1,1],5))

