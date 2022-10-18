import leet_code.common.ListNode

//给定单链表的头节点 head ，请反转链表，并返回反转后的链表的头节点。
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
//
// 
//
// 注意：本题与主站 206 题相同： https://leetcode-cn.com/problems/reverse-linked-list/ 
// Related Topics 递归 链表 👍 45 👎 0


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
class Solution24 {
    private val fakeListNode = ListNode(-1)
    fun reverseList(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }
        reverseListExtra(head)
        return fakeListNode.next
    }

    fun reverseListExtra(head: ListNode): ListNode {
        if (head.next == null) {
            fakeListNode.next = head
            return head
        }
        reverseListExtra(head.next).next = head
        head.next = null
        return head
    }
}
//leetcode submit region end(Prohibit modification and deletion)

fun main() {
//    val test = Solution24()
//    println("hello")
}