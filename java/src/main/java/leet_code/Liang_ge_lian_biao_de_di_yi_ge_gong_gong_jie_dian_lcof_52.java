package leet_code;

import leet_code.common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Liang_ge_lian_biao_de_di_yi_ge_gong_gong_jie_dian_lcof_52 {
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            Set<ListNode> listNodes = new HashSet<>();
            while (headA != null) {
                listNodes.add(headA);
                headA = headA.next;
            }
            while (headB != null) {
                if (listNodes.contains(headB)) {
                    return headB;
                }
                headB = headB.next;
            }
            return null;
        }
    }
}
