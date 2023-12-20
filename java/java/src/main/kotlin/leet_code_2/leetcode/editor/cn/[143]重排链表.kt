import edu.princeton.cs.algs4.LinkedQueue
import edu.princeton.cs.algs4.Queue
import leet_code.common.ListNode
import java.util.*


//给定一个单链表 L 的头节点 head ，单链表 L 表示为：
//
// 
//L0 → L1 → … → Ln - 1 → Ln
// 
//
// 请将其重新排列后变为： 
//
// 
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [1,2,3,4]
//输出：[1,4,2,3] 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 10⁴] 
// 1 <= node.val <= 1000 
// 
// Related Topics 栈 递归 链表 双指针 👍 805 👎 0


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
class Solution143 {

    fun getListNodeSize(head: ListNode?): Int {
        var i = 0
        var temp = head
        while (temp != null) {
            temp = temp.next
            i++
        }
        return i
    }

    fun reverseListNode(head: ListNode?, fakeListNode: ListNode): ListNode? {
        if (head?.next == null) {
            fakeListNode.next = head
            return head
        }
        reverseListNode(head.next, fakeListNode)?.next = head
        head.next = null
        return head
    }

    private var testDebugListNode = ListNode(-1)
    fun reorderList(head: ListNode?): Unit {
        if (head == null) {
            return
        }
        val len = getListNodeSize(head)
        var mid = (len + 1) / 2 - 1

        val firstNode = ListNode(-1)
        firstNode.next = head
        testDebugListNode = firstNode
        var temp = head
        val secondNode = ListNode(-1)
        while (mid-- >= 0) {
            temp = temp?.next
        }
        reverseListNode(temp, secondNode)
        reorderListExtra(firstNode.next, secondNode.next)
    }

    fun reorderListExtra(first: ListNode?, second: ListNode?) {
        if (first == null) {
            second?.next = null
            return
        }
        if (second == null) {
            first.next = null
            return
        }
        val temp = first.next
        val temp2 = second.next
        first.next = second
        second.next = temp
        reorderListExtra(temp, temp2)
    }
}
//leetcode submit region end(Prohibit modification and deletion)

fun main() {
    val test = Solution143()
    var node: ListNode? = ListNode(1)
    node?.next = ListNode(2)
    node?.next?.next = ListNode(3)
    node?.next?.next?.next = ListNode(4)
    node?.next?.next?.next?.next = ListNode(5)
    println("hello")
    val newNode = test.reorderList(node)
    while (node != null) {
        println(node.`val`)
        node = node.next
    }
}