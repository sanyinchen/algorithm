# 给你一个整数数组 nums，请你将该数组升序排列。 
# 
#  
# 
#  
#  
# 
#  示例 1： 
# 
#  
# 输入：nums = [5,2,3,1]
# 输出：[1,2,3,5]
#  
# 
#  示例 2： 
# 
#  
# 输入：nums = [5,1,1,2,0,0]
# 输出：[0,0,1,1,2,5]
#  
# 
#  
# 
#  提示： 
# 
#  
#  1 <= nums.length <= 5 * 10⁴ 
#  -5 * 10⁴ <= nums[i] <= 5 * 10⁴ 
#  
# 
#  Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 👍 966 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class Solution:
    def __init__(self):
        self.less = []
        self.greater = []
        self.temp = []

    def sortArray(self, nums: List[int]) -> List[int]:
        self.temp = [0] * len(nums)
        self.less = [0] * len(nums)
        self.greater = [0] * len(nums)
        self.quick_sort(nums, 0, len(nums) - 1)
        return nums

    def quick_sort(self,alist, first, last):
        if first >= last:
            return
        mid_value = alist[first]
        low = first
        high = last
        while low < high:
            while low < high and alist[high] >= mid_value:
                high -= 1
            alist[low] = alist[high]
            while low < high and alist[low] < mid_value:
                low += 1
            alist[high] = alist[low]
        alist[low] = mid_value
        self.quick_sort(alist, first, low - 1)
        self.quick_sort(alist, low + 1, last)

    def exchange(self, nums: List[int], i, j):
        temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp

    def q_sort(self, nums: List[int], l: int, h: int):
        if l >= h:
            return
        #print('==>', nums[l:h + 1], l, h)
        mid_value = nums[l]
        ii = 0
        jj = 0
        for i in range(l + 1, h + 1):
            if nums[i] <= mid_value:
                self.less[ii] = nums[i]
                ii += 1
            else:
                self.greater[jj] = nums[i]
                jj += 1
        #print('ii', ii, 'jj', jj)
        #print(self.less, mid_value, self.greater)

        i = l
        for i_temp in range(0, ii):
            nums[i] = self.less[i_temp]
            #print(self.less[i_temp])
            i += 1
        nums[i] = mid_value
        mid_index = i
        i += 1
        for i_temp in range(0, jj):
            nums[i] = self.greater[i_temp]
            i += 1
        # print(nums)
        # print(nums, l, h)
        self.q_sort(nums, l, mid_index - 1)
        self.q_sort(nums, mid_index + 1, h)

    def merge_sort(self, nums: List[int], l: int, h: int) -> List[int]:
        if l == h:
            return [nums[l]]
        mid = int((h + l) / 2)
        left = self.merge_sort(nums, l, mid)
        right = self.merge_sort(nums, mid + 1, h)
        # print(left, right, nums[l:h + 1])
        i = l - 1
        while len(left) != 0 and len(right) != 0:
            left_pop = left[0]
            right_pop = right[0]
            if left_pop <= right_pop:
                left.pop(0)
                i += 1
                nums[i] = left_pop
            else:
                right.pop(0)
                i += 1
                nums[i] = right_pop
        while len(left) != 0:
            i += 1
            nums[i] = left.pop(0)
        while len(right) != 0:
            i += 1
            nums[i] = right.pop(0)
        return nums[l:h + 1]


# leetcode submit region end(Prohibit modification and deletion)
s = Solution()
print(s.sortArray([5, 2, 3, 1]))

# print(s.sortArray([5, 1, 1, 2, 0, 0]))
