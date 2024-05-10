# 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 
# 
#  子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子
# 序列。 
# 
#  示例 1： 
# 
#  
# 输入：nums = [10,9,2,5,3,7,101,18]
# 输出：4
# 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
#  
# 
#  示例 2： 
# 
#  
# 输入：nums = [0,1,0,3,2,3]
# 输出：4
#  
# 
#  示例 3： 
# 
#  
# 输入：nums = [7,7,7,7,7,7,7]
# 输出：1
#  
# 
#  
# 
#  提示： 
# 
#  
#  1 <= nums.length <= 2500 
#  -10⁴ <= nums[i] <= 10⁴ 
#  
# 
#  
# 
#  进阶： 
# 
#  
#  你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
#  
# 
#  Related Topics 数组 二分查找 动态规划 👍 3633 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class SegmentTree:
    def __init__(self, n):
        self.n = n
        self.tree = [0] * (4 * self.n)

    def update(self, index, value):
        def update_node(node, start, end):
            if start == end:
                print('[', start, ',', end, ']', '==>', node, value)
                self.tree[node] = value
            else:
                # 执行整数除法并向下取整
                mid = (start + end) // 2
                if start <= index <= mid:
                    update_node(2 * node, start, mid)
                else:
                    update_node(2 * node + 1, mid + 1, end)
                self.tree[node] = max(self.tree[2 * node], self.tree[2 * node + 1])
                print('b[', start, ',', end, ']', '==>', node, value)

        update_node(1, 1, self.n)

    def query(self, query_start, query_end):
        def query_range(node, start, end, query_start, query_end):
            if query_start > end or query_end < start:
                return 0
            if query_start <= start and query_end <= end:
                return self.tree[node]
            mid = (start + end) // 2
            res = 0
            if query_start <= mid:
                res = query_range(2 * node, start, mid, query_start, query_end)
            if query_end > mid:
                res = max(res, query_range(2 * node + 1, mid + 1, end, query_start, query_end))

            return res

        return query_range(1, 1, self.n, query_start, query_end)

    def print(self):
        print(self.tree)


class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        base_min = min(nums)
        base = 0
        if base_min < 0:
            base = 1 - base_min
        print('base', base)
        nums = [x + base for x in nums]
        max_v = max(nums)
        dpSegmentTree = SegmentTree(max_v)
        for i in range(len(nums)):
            cur = nums[i]
            query = dpSegmentTree.query(1, max(cur - 1, 1))
            print('query', 1, cur - 1, query)
            print('set', cur, query + 1)
            dpSegmentTree.update(cur, query + 1)
            dpSegmentTree.print()

        return dpSegmentTree.query(1, max_v)


# leetcode submit region end(Prohibit modification and deletion)

# nums = [10, 9, 2, 5, 3, 7, 101, 18]
nums = [10, 9, 2, 5, 3, 7, 12, 11]
nums = [0, 1, 0, 3, 2, 3]
nums = [4, 10, 4, 3, 8, 9]
nums = [10, 9, 2, 5, 3, 7, 101, 18]
nums = [1, 2, 1, 4, 3, 4]
# nums = [1, 2, 1, 4, 3, 4]
# nums = [0, 1, 0, 3, 2, 3]
# nums = [1, 2, 3]
nums = [1, 1]
# nums = [7, 7, 7, 7, 7]

# nums = [1, 2]

s = Solution()
print(s.lengthOfLIS(nums))
