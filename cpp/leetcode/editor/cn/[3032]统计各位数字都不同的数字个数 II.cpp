//给你两个 正整数 a 和 b ，返回 闭区间 [a, b] 内各位数字都不同的数字个数。
//
// 
//
// 示例 1： 
//
// 
//输入：a = 1, b = 20
//输出：19
//解释：除 11 以外，区间 [1, 20] 内的所有数字的各位数字都不同。因此，答案为 19 。
// 
//
// 示例 2： 
//
// 
//输入：a = 9, b = 19
//输出：10
//解释：除 11 以外，区间 [1, 20] 内的所有数字的各位数字都不同。因此，答案为 10 。
// 
//
// 示例 3： 
//
// 
//输入：a = 80, b = 120
//输出：27
//解释：区间 [80, 120] 内共有 41 个整数，其中 27 个数字的各位数字都不同。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= a <= b <= 1000 
// 
//
// Related Topics 哈希表 数学 动态规划 👍 1 👎 0

# include<common.h>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    int numberCount(int a, int b) {
        function<bool(int)> is_valid = [&](int n) {
            unordered_set<int> set;
            set.insert(n % 10);
            while ((n = n / 10)) {
                if (set.contains(n % 10)) {
                    return false;
                }
                set.insert(n % 10);
            }
            return true;
        };
        int res = 0;
        for (int i = a; i <= b; i++) {
            if (is_valid(i)) {
                res++;
            }
        }
        return res;
    }
};

//leetcode submit region end(Prohibit modification and deletion)
