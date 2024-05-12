import functools


class Solution:
    def multiply(self, A: int, B: int) -> int:

        @functools.cache
        def dfs(n) -> int:
            if n == 0:
                return 0
            if n % 2 == 0:
                return dfs(n / 2) + dfs(n / 2)
            else:
                return A + dfs(n - 1)

        return dfs(B)


s = Solution()
print(s.multiply(3, 4))
