package leet_code_2.leetcode.editor.cn;
////定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。 
////
//// 
////
//// 示例: 
////
//// 输入: 1->2->3->4->5->NULL
////输出: 5->4->3->2->1->NULL 
////
//// 
////
//// 限制： 
////
//// 0 <= 节点个数 <= 5000 
////
//// 
////
//// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/ 
//// Related Topics 递归 链表 👍 379 👎 0
//

import leet_code.common.ListNode;

//leetcode submit region begin(Prohibit modification and deletion)


/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 * var next: ListNode? = null
 * }
 */
class Solution_24java {
    private ListNode fakeListNode = new ListNode(-1);

    ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        reverseListExtra(head);
        return fakeListNode.next;
    }

    ListNode reverseListExtra(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            ListNode temp = new ListNode(head.val);
            fakeListNode.next = temp;
            return temp;
        }
        ListNode oldHead = new ListNode(head.val);
        ListNode newHead = reverseListExtra(head.next);
        oldHead.next = null;
        newHead.next = oldHead;
        return oldHead;
    }


}

//leetcode submit region end(Prohibit modification and deletion)
