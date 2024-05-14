# 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
# 
#  请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
# 
#  
# 
#  示例 1: 
# 
#  
# 输入: [3,2,1,5,6,4] 和 k = 2
# 输出: 5
#  
# 
#  示例 2: 
# 
#  
# 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
# 输出: 4 
# 
#  
# 
#  提示： 
# 
#  
#  1 <= k <= nums.length <= 10⁴ 
#  -10⁴ <= nums[i] <= 10⁴ 
#  
# 
#  
# 
#  
#  注意：本题与主站 215 题相同： https://leetcode-cn.com/problems/kth-largest-element-in-an-
# array/ 
# 
#  Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 100 👎 0
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:

        _k = len(nums) - k
        def dfs(left, right) -> int:
            pIndex = (left + right) // 2
            if pIndex == left:
                return nums[pIndex]
            left_array = []
            right_array = []
            mid_array = []
            for i in range(left, right):
                if nums[i] < nums[pIndex]:
                    left_array.append(nums[i])
                    continue
                if nums[i] > nums[pIndex]:
                    right_array.append(nums[i])
                    continue
                mid_array.append(nums[i])
            tmp = left_array + mid_array + right_array
            for i in range(len(tmp)):
                nums[left + i] = tmp[i]
            mid_min = left + len(left_array)
            mid_max = mid_min + len(mid_array) - 1
            if mid_min <= _k <= mid_max:
                return nums[mid_min]
            if mid_max < _k:
                return dfs(mid_max + 1, right)
            else:
                return dfs(left, mid_min)

        return dfs(0, len(nums))

    # leetcode submit region end(Prohibit modification and deletion)


s = Solution()
nums = [7, 6, 5, 4, 3, 2, 1]
k = 2
print(s.findKthLargest(nums, k))
