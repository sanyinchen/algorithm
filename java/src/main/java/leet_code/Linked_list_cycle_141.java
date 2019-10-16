package leet_code;

import java.util.HashSet;
import java.util.Set;

import leet_code.common.ListNode;

/**
 * Created by sanyinchen on 19-10-16.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-16
 */

class Linked_list_cycle_141 {
    public class Solution {
        public boolean hasCycle(ListNode head) {
            Set<ListNode> cache = new HashSet<>();
            while (head != null) {
                if (cache.contains(head)) {
                    return true;
                } else {
                    cache.add(head);
                    head = head.next;
                }
            }
            return false;
        }
    }
}
