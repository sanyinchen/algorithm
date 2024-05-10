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
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)


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

        update_node(1, 1, self.n)

    def query2(self, query_start, query_end):
        def query_range(node, start, end, query_start, query_end):
            if query_start > end or query_end < start:
                return 0
            if query_start <= start and end <= query_end:
                return self.tree[node]
            mid = (start + end) // 2
            res = 0
            if query_start <= mid:
                res = query_range(2 * node, start, mid, query_start, query_end)
            if mid < query_end:
                res = max(res, query_range(2 * node + 1, mid + 1, end, query_start, query_end))
            return res

        return query_range(1, 1, self.n, query_start, query_end)

    # def query(self, start, end):
    #     def query_range(node, query_start, query_end, L, R):
    #
    #         if query_start > R or query_end < L:
    #             return 0
    #         if L <= query_start and query_end <= R:
    #             return self.tree[node]
    #         mid = (query_start + query_end) // 2
    #         res = 0
    #         if L <= mid:
    #             res = query_range(2 * node, query_start, mid, L, R)
    #         if R > mid:
    #             res = max(res, query_range(2 * node + 1, mid + 1, query_end, L, R))
    #         return res
    #
    #     return query_range(1, 1, self.n, start, end)
    # return query2(1, 1, self.n, L, R)


class Solution:
    def lengthOfLIS(self, nums: List[int], k: int) -> int:
        max_v = max(nums)
        dpSegmentTree = SegmentTree(max_v)
        for i in range(len(nums)):
            cur = nums[i]
            if cur == 1:
                dpSegmentTree.update(cur, 1)
            else:
                query = dpSegmentTree.query2(max(cur - k, 1), cur - 1)
                # query2 = dpSegmentTree.query2(1, 1, u, max(cur - k, 1), cur - 1)
                res = query + 1
                # print('query', max(cur - k, 1), cur - 1, query)
                # print('set', cur, res)
                dpSegmentTree.update(cur, res)
                # print(dpSegmentTree.tree)

        return dpSegmentTree.tree[1]


# leetcode submit region end(Prohibit modification and deletion)
s = Solution()
nums = [7, 4, 5, 1, 8, 12, 4, 7]
k = 5
# nums = [1, 5]
# k = 1
print(s.lengthOfLIS(nums, k))
