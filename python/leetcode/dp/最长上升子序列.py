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

        update_node(1, 1, self.n)

    def getNode(self, index):
        if index <= 0 or index > self.n:
            return 0
        return self.tree[index]

    def query(self, query_start, query_end):
        def query_range(node, L, R, query_start, query_end):

            if query_start > R or query_end < L:
                return 0
            if L <= query_start and query_end <= R:
                return self.tree[node]
            mid = (query_start + query_end) // 2
            res = 0
            if L <= mid:
                res = query_range(2 * node, L, R, query_start, mid)
            if R > mid:
                res = max(res, query_range(2 * node + 1, L, R, mid + 1, query_end))
            return res

        return query_range(1, query_start, query_end, 1, self.n)


class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        base_min = min(nums)
        base = 0
        if base_min <= 0:
            base = 1 - base_min
        nums = [x + base for x in nums]
        # print(nums)
        max_v = max(nums)
        dpSegmentTree = SegmentTree(max_v)
        for i in range(len(nums)):
            cur = nums[i]
            if cur == 1:
                dpSegmentTree.update(cur, 1)
            else:
                query = dpSegmentTree.query(1, cur - 1)
                res = query + 1
                dpSegmentTree.update(cur, res)

        return dpSegmentTree.getNode(1)


# nums = [10, 9, 2, 5, 3, 7, 101, 18]
# # nums = [1, 2, 3]
# # nums = [3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12]
# # nums = [7, 7, 7, 7, 7, 7, 7]
# nums = [10, 9, 2, 5, 3, 7, 20, 18]
nums = [0, 1, 0, 3, 2, 3]
s = Solution()
print(s.lengthOfLIS(nums))
