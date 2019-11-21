package leet_code

import leet_code.common.ListNode

/**
 * Created by sanyinchen on 19-11-21.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-11-21
 */
class Remove_linked_list_elements_203 {

    fun removeElements(head: ListNode?, value: Int): ListNode? {
        if (head == null) {
            return null
        }
        var mockheader = ListNode(-1)
        var temp = head
        while (temp != null) {
            if (temp.`val` != value) {
                mockheader.next = temp;
                break
            }
            temp = temp.next
        }

        while (temp != null) {
            var pre = temp
            while (temp?.next?.`val` == value) {
                pre.next = temp.next.next
                temp = pre
            }

            temp = temp?.next
        }

        return mockheader.next

    }


}

fun main() {
    var header = ListNode(1)
    header.next = ListNode(2)
    header.next.next = ListNode(2)
    header.next.next.next = ListNode(1)
    Remove_linked_list_elements_203().removeElements(header, 2)
}