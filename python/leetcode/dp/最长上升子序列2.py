from typing import List


class Solution:
    def lengthOfLIS(self, nums: List[int], k: int) -> int:
        u = max(nums)
        mx = [0] * (4 * u)

        def modify(o: int, l: int, r: int, i: int, val: int) -> None:
            if l == r:
                mx[o] = val
                print('[', l, ',', r, ']', '==>', o, val)
                return
            m = (l + r) // 2
            if i <= m:
                modify(o * 2, l, m, i, val)
            else:
                modify(o * 2 + 1, m + 1, r, i, val)
            mx[o] = max(mx[o * 2], mx[o * 2 + 1])
            print('b[', l, ',', r, ']', '==>', o, val)

        # 返回区间 [L,R] 内的最大值
        def query(o: int, l: int, r: int, L: int, R: int) -> int:  # L 和 R 在整个递归过程中均不变，将其大写，视作常量
            if L <= l and r <= R: return mx[o]
            res = 0
            m = (l + r) // 2
            if L <= m: res = query(o * 2, l, m, L, R)
            if R > m: res = max(res, query(o * 2 + 1, m + 1, r, L, R))
            return res

        for x in nums:
            if x == 1:
                modify(1, 1, u, 1, 1)
            else:
                q = query(1, 1, u, max(x - k, 1), x - 1)
                res = 1 + q
                print('query', max(x - k, 1), x - 1, q)
                print('set', x, res)
                modify(1, 1, u, x, res)
                print(mx)
        return mx[1]


s = Solution()
nums = [7, 4, 5, 1, 8, 12, 4, 7]
k = 5
print(s.lengthOfLIS(nums, k))
