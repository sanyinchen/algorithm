import sys


class Solution:
    def minimumOperationsToMakeKPeriodic(self, word: str, k: int) -> int:
        comp_map = {}
        for i in range(0, len(word), k):
            sub_str = word[i:i + k]
            if sub_str in comp_map:
                comp_map[sub_str] += 1
            else:
                comp_map[sub_str] = 1

        max_v = 0
        for key, value in comp_map.items():
            max_v = max(value, max_v)

        return int(len(word) / k) - max_v


s = Solution()
print(s.minimumOperationsToMakeKPeriodic('leetcodeleet', 4))
print(s.minimumOperationsToMakeKPeriodic('leetcoleet', 2))
