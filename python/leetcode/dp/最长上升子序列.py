from typing import List


# class Solution:
#     def lengthOfLIS(self, nums: List[int]) -> int:
#         self.dp = [-1 for _ in range(len(nums))]
#         max_v = -1
#         for i in range(len(nums)):
#             max_v = max(self.lengthOfLISHelper(nums, i), max_v)
#         return max_v
#
#     def lengthOfLISHelper(self, nums: List[int], index: int) -> int:
#         # print(index)
#         if self.dp[index] != -1:
#             return self.dp[index]
#         max_v = 1
#         for i in range(index + 1):
#             if nums[i] < nums[index]:
#                 max_v = max(self.lengthOfLISHelper(nums, i) + 1, max_v)
#         # print(index, max_v)
#         self.dp[index] = max_v
#         return self.dp[index]

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        u = max(nums)
        mx = [0] * (4 * u)
        k = 1

        def modify(o: int, l: int, r: int, i: int, val: int) -> None:
            if l == r:
                print('[', l, ',', r, ']', '==>', o, val)
                mx[o] = val
                return
            m = (l + r) // 2
            if i <= m:
                modify(o * 2, l, m, i, val)
            else:
                modify(o * 2 + 1, m + 1, r, i, val)
            mx[o] = max(mx[o * 2], mx[o * 2 + 1])
            print('b[', l, ',', r, ']', '==>', o, mx[o])

        # 返回区间 [L,R] 内的最大值
        def query(o: int, l: int, r: int, L: int, R: int) -> int:  # L 和 R 在整个递归过程中均不变，将其大写，视作常量
            print('query', l, r, ' in ', L, R)
            if L <= l and r <= R:
                print('2 query', l, r, ' in ', L, R,mx[o],o)
                return mx[o]
            res = 0
            m = (l + r) // 2
            if L <= m: res = query(o * 2, l, m, L, R)
            if R > m: res = max(res, query(o * 2 + 1, m + 1, r, L, R))
            print('3 query', l, r, ' in ', L, R, res)
            return res

        for x in nums:
            if x == 1:
                modify(1, 1, u, 1, 1)
            else:
                q = query(1, 1, u, 1, x - 1)
                print('q', 1, x - 1, q)
                res = 1 + q
                print('set', x, res)
                modify(1, 1, u, x, res)
                print(mx)

        return query(1, 1, u, 1, u)


# nums = [10, 9, 2, 5, 3, 7, 101, 18]
# # nums = [1, 2, 3]
# # nums = [3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12]
# # nums = [7, 7, 7, 7, 7, 7, 7]
# nums = [10, 9, 2, 5, 3, 7, 20, 18]
nums = [1, 1]
s = Solution()
print(s.lengthOfLIS(nums))
