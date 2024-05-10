# 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
# 
#  子数组 是数组中的一个连续部分。 
# 
#  
# 
#  示例 1： 
# 
#  
# 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
# 输出：6
# 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
#  
# 
#  示例 2： 
# 
#  
# 输入：nums = [1]
# 输出：1
#  
# 
#  示例 3： 
# 
#  
# 输入：nums = [5,4,-1,7,8]
# 输出：23
#  
# 
#  
# 
#  提示： 
# 
#  
#  1 <= nums.length <= 10⁵ 
#  -10⁴ <= nums[i] <= 10⁴ 
#  
# 
#  
# 
#  进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
# 
#  Related Topics 数组 分治 动态规划 👍 6657 👎 0
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class SegmentTree:
    def __init__(self, nums):
        self.n = len(nums)
        self.tree = [0] * (4 * self.n)

    def update(self, index, value):
        def update_node(node, start, end):
            if start == end:
                print(node, value)
                self.tree[node] = value
            else:
                # 执行整数除法并向下取整
                mid = (start + end) // 2
                if start <= index <= mid:
                    update_node(2 * node, start, mid)
                else:
                    update_node(2 * node + 1, mid + 1, end)
                self.tree[node] = self.tree[2 * node] + self.tree[2 * node + 1]

        update_node(1, 0, self.n - 1)

    def query(self, query_start, query_end):
        def query_range(node, query_start, query_end, L, R):
            if query_start > R or query_end < L:
                return 0
            if query_start <= L and query_end >= R:
                return self.tree[node]
            mid = (query_start + query_end) // 2
            res = 0
            if L <= query_start <= mid:
                res += query_range(2 * node, query_start, mid, L, R)
            else:
                res = query_range(2 * node + 1, mid + 1, query_end, L, R)
            return res

        return query_range(1, query_start, query_end, 0, self.n - 1)


class Solution:
    def maxSubArray(self, nums: List[int]) -> int:

# leetcode submit region end(Prohibit modification and deletion)
