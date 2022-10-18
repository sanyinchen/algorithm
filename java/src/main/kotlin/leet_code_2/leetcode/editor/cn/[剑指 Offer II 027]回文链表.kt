import leet_code.common.ListNode
import java.util.*

//给定一个链表的 头节点 head ，请判断其是否为回文链表。
//
// 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: head = [1,2,3,3,2,1]
//输出: true 
//
// 示例 2： 
//
// 
//
// 
//输入: head = [1,2]
//输出: false
// 
//
// 
//
// 提示： 
//
// 
// 链表 L 的长度范围为 [1, 10⁵] 
// 0 <= node.val <= 9 
// 
//
// 
//
// 进阶：能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// 
//
// 注意：本题与主站 234 题相同：https://leetcode-cn.com/problems/palindrome-linked-list/ 
// Related Topics 栈 递归 链表 双指针 👍 31 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution27 {
    fun isPalindrome(head: ListNode?): Boolean {
        return isPalindromeExtra(head,ArrayDeque())
    }

    private fun isPalindromeExtra(head: ListNode?, list: Deque<Int>): Boolean {
        if (head == null) {
            return true
        }
        list.add(head.`val`)
        if (!isPalindromeExtra(head.next, list)) {
            return false
        }
        return list.pollFirst() == head.`val`
    }
}
//leetcode submit region end(Prohibit modification and deletion)

fun main() {
//    val test = Solution()
//    println("hello")
}