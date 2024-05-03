# 给你两个整数数组 nums1 和 nums2。 
# 
#  从 nums1 中移除两个元素，并且所有其他元素都与变量 x 所表示的整数相加。如果 x 为负数，则表现为元素值的减少。 
# 
#  执行上述操作后，nums1 和 nums2 相等 。当两个数组中包含相同的整数，并且这些整数出现的频次相同时，两个数组 相等 。 
# 
#  返回能够实现数组相等的 最小 整数 x 。 
# 
#  
# 
#  示例 1: 
# 
#  
#  输入：nums1 = [4,20,16,12,8], nums2 = [14,18,10] 
#  
# 
#  输出：-2 
# 
#  解释： 
# 
#  移除 nums1 中下标为 [0,4] 的两个元素，并且每个元素与 -2 相加后，nums1 变为 [18,14,10] ，与 nums2 相等。 
# 
#  示例 2: 
# 
#  
#  输入：nums1 = [3,5,5,3], nums2 = [7,7] 
#  
# 
#  输出：2 
# 
#  解释： 
# 
#  移除 nums1 中下标为 [0,3] 的两个元素，并且每个元素与 2 相加后，nums1 变为 [7,7] ，与 nums2 相等。 
# 
#  
# 
#  提示： 
# 
#  
#  3 <= nums1.length <= 200 
#  nums2.length == nums1.length - 2 
#  0 <= nums1[i], nums2[i] <= 1000 
#  测试用例以这样的方式生成：存在一个整数 x，nums1 中的每个元素都与 x 相加后，再移除两个元素，nums1 可以与 nums2 相等。 
#  
# 
#  👍 1 👎 0
import sys
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def minimumAddedInteger(self, nums1: List[int], nums2: List[int]) -> int:
        nums1.sort()
        nums2.sort()
        diff = sys.maxsize
        for i in range(len(nums1)):
            for j in range(len(nums1)):
                if i == j:
                    continue
                #print('del', i, j)
                diff = min(diff, self.get_diff(nums1, nums2, i, j))
                #print(diff)
        return diff

    def get_diff(self, nums1: List[int], nums2: List[int], del_i: int, del_j: int):
        i = 0
        j = 0
        diff = sys.maxsize

        while i < len(nums1):
            if i == del_i:
                i += 1
                continue
            if i == del_j:
                i += 1
                continue
            if diff == sys.maxsize:
                diff = nums2[j] - nums1[i]
            else:
                # print(i, j)
                if (nums2[j] - nums1[i]) != diff:
                    return sys.maxsize
            i += 1
            j += 1
        return diff


# leetcode submit region end(Prohibit modification and deletion)
s = Solution()
# nums1 = [3, 5, 5, 3]
# nums2 = [7, 7]
#
# nums1 = [4, 20, 16, 12, 8]
# nums2 = [14, 18, 10]

nums1 = [9, 4, 3, 9, 4]
nums2 = [7, 8, 8]
print(s.minimumAddedInteger(nums1, nums2))
