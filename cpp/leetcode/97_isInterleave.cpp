//
// Created by sanyinchen on 7/27/25.
//
#include <common.h>
#include <tuple>
#include <unordered_map>
#include <functional>

using namespace std;

struct TupleHash {
    template <typename T>
    size_t operator()(const T& t) const {
        return hash_combine(t);
    }

private:
    // 可递归处理多个字段
    template <typename Tuple, size_t Index = 0>
    static typename enable_if<Index == tuple_size<Tuple>::value, size_t>::type
    hash_combine(const Tuple&) {
        return 0;
    }

    template <typename Tuple, size_t Index = 0>
    static typename enable_if<Index < tuple_size<Tuple>::value, size_t>::type
    hash_combine(const Tuple& t) {
        const size_t current = hash<typename tuple_element<Index, Tuple>::type>()(get<Index>(t));
        const size_t next = hash_combine<Tuple, Index + 1>(t);
        return current ^ (next << 1); // XOR + 位移组合
    }
};


class Solution {
public:
    bool isInterleave(string s1, string s2, string s3) {
        const int len1 = s1.size();
        const int len2 = s2.size();
        const int len3 = s3.size();
        if (len1 + len2 != len3) {
            return false;
        }
        unordered_map<tuple<int, int, int>, bool, TupleHash> memo;
        function<bool(int, int, int)> dp = [&](int i, int j, int k) {
            if (i >= len1 && j >= len2) {
                return k == len3;
            }
            tuple<int, int, int> key = make_tuple(i, j, k);
            if (memo.find(key) != memo.end()) {
                return memo[key];
            }
            const char s1_c = s1[i];
            const char s2_c = s2[j];
            const char s3_c = s3[k];
            bool res = false;
            if (s1_c == s3_c) {
                res |= dp(i + 1, j, k + 1);
            }
            if (s2_c == s3_c) {
                res |= dp(i, j + 1, k + 1);
            }
            memo[key] = res;
            return res;
        };
        return dp(0, 0, 0);
    }
};
