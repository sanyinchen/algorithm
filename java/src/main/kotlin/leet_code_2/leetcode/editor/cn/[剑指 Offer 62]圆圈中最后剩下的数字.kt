import java.util.*
import kotlin.collections.ArrayList

//0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
// 
//
// 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。 
//
// 
//
// 示例 1： 
//
// 
//输入: n = 5, m = 3
//输出: 3
// 
//
// 示例 2： 
//
// 
//输入: n = 10, m = 17
//输出: 2
// 
//
// 
//
// 限制： 
//
// 
// 1 <= n <= 10^5 
// 1 <= m <= 10^6 
// 
// Related Topics 递归 数学 👍 546 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution62 {
    fun lastRemaining(n: Int, m: Int): Int {
        if (n == 0) {
            return 0
        }
        val array = ArrayList<Int>()
        for (i in 0 until n) {
            array.add(i)
        }
        return lastRemainingExtra(array, 0, m)
    }

    fun getNext(array: ArrayList<Int>, i: Int, m: Int): Int {
        return (i + m - 1) % array.size
    }

    fun lastRemainingExtra(array: ArrayList<Int>, i: Int, m: Int): Int {
        val nextDel = getNext(array, i, m)
        // println("$nextDel ${array[nextDel]} ")
        if (array.size == 1) {
            return array[0]
        }
        array.removeAt(nextDel)
        return lastRemainingExtra(array, nextDel, m)
    }
}
//leetcode submit region end(Prohibit modification and deletion)

fun main() {
    val test = Solution62()
    println("${test.lastRemaining(5, 3)}")
}