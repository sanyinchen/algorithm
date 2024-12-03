// 409-longest-palindrome

//给定一个包含大写字母和小写字母的字符串
// s ，返回 通过这些字母构造成的 最长的 回文串 的长度。 
//
// 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入:s = "abccccdd"
//输出:7
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
//
// 示例 2: 
//
// 
//输入:s = "a"
//输出:1
//解释：可以构造的最长回文串是"a"，它的长度是 1。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 2000 
// s 只由小写 和/或 大写英文字母组成 
// 
//
// Related Topics 贪心 哈希表 字符串 👍 617 👎 0


#include "../../comm.h"


using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    int longestPalindrome(string s) {
        const int maxLen = 'z' + 1;
        int words[maxLen] = {0};
        for (int i = 0; i < s.length(); ++i) {
            words[s[i]]++;
        }
        bool odd = false;
        int sum = 0;
        for (int j = 0; j < maxLen; ++j) {
            if (words[j] == 1) {
                odd = true;
            }
            if (words[j] % 2 == 0) {
                sum += words[j];
            } else {
                sum += (words[j] / 2 * 2);
                odd = true;
            }
        }

        return odd ? sum + 1 : sum;
    }
};
//leetcode submit region end(Prohibit modification and deletion)

int main() {
    Solution s;
}