package leet_code;

import java.util.HashSet;
import java.util.Set;

import leet_code.common.ListNode;

/**
 * Created by sanyinchen on 19-11-9.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-11-9
 */

class Linked_list_cycle_ii_142 {
    public class Solution {

        public ListNode detectCycle(ListNode head) {
            ListNode mockHeader = new ListNode(-1);
            mockHeader.next = head;
            ListNode temp = mockHeader.next;
            Set<ListNode> cache = new HashSet<>();

            while (temp != null) {
                if (cache.contains(temp)) {
                    return temp;
                } else {
                    cache.add(temp);
                }
                temp = temp.next;
            }
            return null;
        }

    }
}
