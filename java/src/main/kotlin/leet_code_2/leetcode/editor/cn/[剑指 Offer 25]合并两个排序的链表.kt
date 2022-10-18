import leet_code.common.ListNode

//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
//
// 示例1： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4 
//
// 限制： 
//
// 0 <= 链表长度 <= 1000 
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/ 
// Related Topics 递归 链表 👍 217 👎 0


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
class Solution25 {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null && l2 == null) {
            return null
        }
        if (l1 == null) {
            return l2
        }
        if (l2 == null) {
            return l1
        }
        val fakeHead = ListNode(-1)
        mergeTwoListsExtra(l1, l2, fakeHead)
        return fakeHead.next
    }

    fun mergeTwoListsExtra(l1: ListNode?, l2: ListNode?, merged: ListNode) {
        if (l1 == null) {
            merged.next = l2
            return
        }
        if (l2 == null) {
            merged.next = l1
            return
        }
        val l1Value = l1.`val`
        val l2Value = l2.`val`
        if (l1Value <= l2Value) {
            merged.next = ListNode(l1Value)
            mergeTwoListsExtra(l1.next, l2, merged.next)
        } else {
            merged.next = ListNode(l2Value)
            mergeTwoListsExtra(l1, l2.next, merged.next)
        }


    }
}
//leetcode submit region end(Prohibit modification and deletion)

fun main() {
//    val test = Solution()
//    println("hello")
}