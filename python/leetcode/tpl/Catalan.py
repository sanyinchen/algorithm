# 卡特兰公式
import functools


@functools.cache
def catalan(n) -> int:
    # print(n)
    if n <= 1:
        return 1
    res = 0
    for x in range(n):
        res += catalan(x) * catalan(n - 1 - x)
    return res


for i in range(10):
    print(catalan(i))
# print(catalan(5))
