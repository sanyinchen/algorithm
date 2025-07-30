//给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数 。 
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
//
// 
//
// 提示： 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 和 word2 由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 3715 👎 0

# include<common.h>

//leetcode submit region begin(Prohibit modification and deletion)

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
    int minDistance(string word1, string word2) {
        unordered_map<tuple<int, int>, int, TupleHash> memo;
        function<int(int, int)> dp = [&](int i, int j)-> int {
            if (i == word1.length()) return word2.length() - j;
            if (j == word2.length()) return word1.length() - i;
            auto key = tuple(i, j);
            if (memo.find(key) != memo.end()) return memo[key];
            int step = 0;
            if (word1[i] != word2[j]) {
                step = min(min(dp(i + 1, j) + 1, dp(i, j + 1) + 1), dp(i + 1, j + 1) + 1);
            }
            else {
                step = dp(i + 1, j + 1);
            }
            memo[key] = step;
            return step;
        };
        return dp(0, 0);
    }
};

//leetcode submit region end(Prohibit modification and deletion)
// int main() {
//     Solution solution;
//     cout << solution.minDistance("horse", "ros");
// }
