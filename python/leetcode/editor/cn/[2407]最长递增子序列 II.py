# 给你一个整数数组 nums 和一个整数 k 。 
# 
#  找到 nums 中满足以下要求的最长子序列： 
# 
#  
#  子序列 严格递增 
#  子序列中相邻元素的差值 不超过 k 。 
#  
# 
#  请你返回满足上述要求的 最长子序列 的长度。 
# 
#  子序列 是从一个数组中删除部分元素后，剩余元素不改变顺序得到的数组。 
# 
#  
# 
#  示例 1： 
# 
#  输入：nums = [4,2,1,4,3,4,5,8,15], k = 3
# 输出：5
# 解释：
# 满足要求的最长子序列是 [1,3,4,5,8] 。
# 子序列长度为 5 ，所以我们返回 5 。
# 注意子序列 [1,3,4,5,8,15] 不满足要求，因为 15 - 8 = 7 大于 3 。
#  
# 
#  示例 2： 
# 
#  输入：nums = [7,4,5,1,8,12,4,7], k = 5
# 输出：4
# 解释：
# 满足要求的最长子序列是 [4,5,8,12] 。
# 子序列长度为 4 ，所以我们返回 4 。
#  
# 
#  示例 3： 
# 
#  输入：nums = [1,5], k = 1
# 输出：1
# 解释：
# 满足要求的最长子序列是 [1] 。
# 子序列长度为 1 ，所以我们返回 1 。
#  
# 
#  
# 
#  提示： 
# 
#  
#  1 <= nums.length <= 10⁵ 
#  1 <= nums[i], k <= 10⁵ 
#  
# 
#  Related Topics 树状数组 线段树 队列 数组 分治 动态规划 单调队列 👍 78 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
from functools import lru_cache

from typing import List


class SegmentTree:
    def __init__(self, n):
        self.n = n
        self.tree = [0] * (4 * self.n)

    def update(self, index, value):
        def update_node(node, start, end):
            if start == end:
                # print('[', start, ',', end, ']', '==>', node, value)
                self.tree[node] = value
            else:
                # 执行整数除法并向下取整
                mid = (start + end) // 2
                if start <= index <= mid:
                    update_node(2 * node, start, mid)
                else:
                    update_node(2 * node + 1, mid + 1, end)
                self.tree[node] = max(self.tree[2 * node], self.tree[2 * node + 1])
                # print('b[', start, ',', end, ']', '==>', node, value)

        update_node(1, 0, self.n - 1)

    def query(self, query_start, query_end):
        def query_range(node, start, end, query_start, query_end):
            if query_start > end or query_end < start:
                return 0
            if query_start <= start and query_end >= end:
                return self.tree[node]
            mid = (start + end) // 2
            return max(query_range(2 * node, start, mid, query_start, query_end),
                       query_range(2 * node + 1, mid + 1, end, query_start, query_end))

        return query_range(1, 0, self.n - 1, query_start, query_end)

    def print(self):
        print(self.tree)


class Solution:
    def lengthOfLIS(self, nums: List[int], k: int) -> int:
        if len(nums) == 1:
            return 1
        base_min = min(nums)
        base = 0
        if base_min <= 0:
            base = 1 - base_min
        # print(base)
        nums = [x + base for x in nums]
        max_v = max(nums)
        dpSegmentTree = SegmentTree(max_v)
        for i in range(len(nums)):
            cur = nums[i]
            query = dpSegmentTree.query(max(cur - k - 1, 0), cur - 1)
            # print('query', 1, cur - 1, query)
            # print('set', cur, query + 1)
            dpSegmentTree.update(cur, query + 1)
            # dpSegmentTree.print()

        return dpSegmentTree.query(0, max_v - 1)


# leetcode submit region end(Prohibit modification and deletion)
s = Solution()
nums = [7, 4, 5, 1, 8, 12, 4, 7]
k = 5
# nums = [1, 5]
# k = 1
print(s.lengthOfLIS(nums, k))
