package leet_code_part2;

import leet_code.common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Cong_wei_dao_tou_da_yin_lian_biao_lcof_06 {
    class Solution {

        public int[] reversePrint(ListNode head) {
            List<Integer> res = new ArrayList<>();
            while (head != null) {
                res.add(head.val);
                head = head.next;
            }
            int[] collect = new int[res.size()];
            for (int i = res.size() - 1, j = 0; i >= 0; i--) {
                collect[j++] = res.get(i);
            }
            return collect;
        }
    }
}
