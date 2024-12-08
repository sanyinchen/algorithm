// 50-powx-n

//实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xⁿ ）。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100
// 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25
// 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -231 <= n <= 231-1 
// n 是一个整数 
// 要么 x 不为零，要么 n > 0 。 
// -104 <= xⁿ <= 104 
// 
//
// Related Topics 递归 数学 👍 1411 👎 0


#include "../../comm.h"


using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution
{
public:
    double myPow(double x, int n)
    {
        long ext_n = (long)n;
        if (ext_n < 0)
        {
            return 1.0 / fastPower(x, -ext_n);
        }
        return fastPower(x, ext_n);
    }

    // 快速幂函数，计算 (base^exp)
    double fastPower(double base, long exp)
    {
        if (exp == 0)
        {
            return 1; // 任意数的 0 次方为 1
        }
        double half = fastPower(base, exp / 2); // 递归计算一半的幂
        half = (half * half); // 平方
        if (exp % 2 != 0)
        {
            half = (half * base); // 如果指数是奇数，还需额外乘一次 base
        }
        return half;
    }
};

//leetcode submit region end(Prohibit modification and deletion)

int main()
{
    Solution s;
    cout << s.myPow(1.00000, -2147483648) << endl;
}
