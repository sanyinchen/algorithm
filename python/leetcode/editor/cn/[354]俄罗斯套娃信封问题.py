# 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。 
# 
#  当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。 
# 
#  请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。 
# 
#  注意：不允许旋转信封。 
# 
#  示例 1： 
# 
#  
# 输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
# 输出：3
# 解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。 
# 
#  示例 2： 
# 
#  
# 输入：envelopes = [[1,1],[1,1],[1,1]]
# 输出：1
#  
# 
#  
# 
#  提示： 
# 
#  
#  1 <= envelopes.length <= 10⁵ 
#  envelopes[i].length == 2 
#  1 <= wi, hi <= 10⁵ 
#  
# 
#  Related Topics 数组 二分查找 动态规划 排序 👍 1009 👎 0
from functools import cmp_to_key, lru_cache
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)

class SegmentTree:
    def __init__(self, nums):
        self.n = len(nums)
        # 构造满二叉树
        self.tree = [0] * (2 * self.n + 2)

    def update(self, index, value):
        def update_node(node, start, end):
            if start == end:
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
        def query_range(node, start, end, query_start, query_end):
            if query_start > end or query_end < start:
                return 0
            if query_start <= start and query_end >= end:
                return self.tree[node]
            mid = (start + end) // 2
            left_sum = query_range(2 * node, start, mid, query_start, query_end)
            right_sum = query_range(2 * node + 1, mid + 1, end, query_start, query_end)
            return left_sum + right_sum

        return query_range(1, 0, self.n - 1, query_start, query_end)


class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:

        envelopes = sorted(envelopes, key=lambda x: (x[0], -x[1]))
        print(envelopes)
        nums = []
        for i in range(len(envelopes)):
            nums.append(envelopes[i][1])
        print(nums)
        dpSegmentTree = SegmentTree(nums)
        max_v = 1

        for i in range(len(nums)):
            res = dpSegmentTree.query(1, nums[i] - 1) + 1
            print(i, res)
            max_v = max(max_v, res)
            dpSegmentTree.update(nums[i], res)

        return max_v


# leetcode submit region end(Prohibit modification and deletion)
s = Solution()
envelopes = [[5, 4], [6, 4], [6, 7], [2, 3]]
print(s.maxEnvelopes(envelopes))
