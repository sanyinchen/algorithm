class Solution:
    def isValid(self, word: str) -> bool:
        check = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}
        first_check = 0
        second_check = 0
        for char in word:
            if '9' >= char >= '0':
                continue
            if ('a' <= char <= 'z') or ('A' <= char <= 'Z'):
                if char in check:
                    first_check += 1
                else:
                    second_check += 1
                continue
            return False
        return first_check > 0 and second_check > 0 and len(word) >= 3
