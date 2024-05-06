class Solution:
    def minAnagramLength(self, s: str) -> int:
        if len(s) == 1:
            return 1
        str_len = len(s)
        char_list = list(s)

        for step in range(1, str_len):
            if str_len % step != 0:
                continue
            stop = False
            t_len = 0
            t = ''
            for i in range(0, len(char_list), step):
                temp = []
                for j in range(i, i + step):
                    temp.append(char_list[j])

                tmp_t = '_'.join(sorted(temp))
                t_len = len(temp)
                # print(tmp_t, t_len)
                if t == '':
                    t = tmp_t
                else:
                    if t != tmp_t:
                        stop = True
                        break
                if stop:
                    break
            if stop is False:
                return t_len

        return len(s)


s = Solution()
print(s.minAnagramLength('abba'))
print(s.minAnagramLength('cdef'))

print(s.minAnagramLength('oionssonoi'))
