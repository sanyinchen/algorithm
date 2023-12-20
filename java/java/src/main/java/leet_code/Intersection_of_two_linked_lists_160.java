package leet_code;

import java.util.List;

import leet_code.common.ListNode;

/**
 * Created by sanyinchen on 20-1-19.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-1-19
 */

class Intersection_of_two_linked_lists_160 {
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode temp;
            while (headA != null) {
                // System.out.println("A:" + headA.val);
                temp = headB;
                while (temp != null) {
                    // System.out.println("B:" + temp.val);
                    if (headA == temp) {
                        return temp;
                    }
                    temp = temp.next;
                }
                headA = headA.next;
            }
            return null;
        }
    }
}
