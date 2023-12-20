package leet_code;

import java.util.ArrayList;
import java.util.List;

import leet_code.common.ListNode;

/**
 * Created by sanyinchen on 19-10-16.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-16
 */

class Palindrome_linked_list_234 {
    class Solution {
        public boolean isPalindrome(ListNode head) {

            List<Integer> res = new ArrayList<>();
            while (head != null) {
                res.add(head.val);
                head = head.next;
            }
            for (int i = 0, j = res.size() - 1; i <= j; i++, j--) {
                if (!res.get(i).equals(res.get(j))) {
                    return false;
                }
            }
            return true;
        }
    }
}
