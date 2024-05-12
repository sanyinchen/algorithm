import functools


class Solution:
    def myPow(self, x: float, n: int) -> float:
        @functools.cache
        def dfs(n):
            if n == 0:
                return 1
            if n % 2 == 0:
                return dfs(n / 2) * dfs(n / 2)
            else:
                return dfs((n - 1) / 2) * dfs((n - 1) / 2) * x

        if n < 0:
            return 1 / dfs(abs(n))
        else:
            return dfs(abs(n))


s = Solution()

print(s.myPow(2, 10))
