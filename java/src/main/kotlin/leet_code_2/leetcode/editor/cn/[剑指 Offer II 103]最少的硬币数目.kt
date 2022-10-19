import java.util.*

//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：coins = [1], amount = 1
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：coins = [1], amount = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
//
// 
//
// 
// 注意：本题与主站 322 题相同： https://leetcode-cn.com/problems/coin-change/ 
//
// Related Topics 广度优先搜索 数组 动态规划 👍 55 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_103 {
    //      class Solution {
    var cache: HashMap<Int, Int> = HashMap()
    var min = Int.MAX_VALUE
    fun coinChangeHelper(sum: Int, coins: IntArray, index: Int): Int {

        if (index == coins.size) {
            return Int.MAX_VALUE
        }
        // println("$index")
        var minResult = Int.MAX_VALUE
        val cur = coins[index]
        var maxCount: Int = sum / cur
        while (maxCount >= 0) {
            // println("$index $maxCount $cur")
            val rest: Int = sum - maxCount * cur
            if (rest == 0) {
                // println("===========>")
                return maxCount
            }

            val restCount = coinChangeHelper(rest, coins, index + 1)
            if (restCount == -2) {
                return -2
            }
            if (restCount != Int.MAX_VALUE) {
                minResult = Math.min(minResult, maxCount + restCount)
                if (maxCount + restCount > min) {
                    maxCount--
                    continue
                }
            }
            if (index == 0) {
                //  println("minResult:$minResult ${maxCount + restCount}")
                min = Math.min(min, minResult)
            }
            maxCount--
        }
        cache[sum] = minResult
        return minResult
    }

    fun coinChange(coins: IntArray, amount: Int): Int {
        if (amount == 0) {
            return 0
        }
        cache.clear()
        coins.sortDescending()

        val res = coinChangeHelper(amount, coins, 0)

        if (min == Int.MAX_VALUE) {
            if (res == Int.MAX_VALUE) {
                return -1
            }
            return res
        }
        return min
    }
}
//leetcode submit region end(Prohibit modification and deletion)

fun main() {
    var coinArray = intArrayOf(1, 2, 5)
    var amount = 11
    coinArray = intArrayOf(3, 7, 405, 436)
    amount = 8839
    coinArray = intArrayOf(186, 419, 83, 408)
    amount = 6249
    coinArray = intArrayOf(411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422)
    amount = 9864
    coinArray = intArrayOf(1)
    amount = 1

    val test = Solution_103()
    System.out.println(test.coinChange(coinArray, amount))
}