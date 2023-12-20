package leet_code;

/**
 * Created by sanyinchen on 19-9-11.
 * <p>
 * from https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-11
 */

class Link_Solution_206 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {

        public ListNode reverseList(ListNode head) {
            ListNode emptyHeader = new ListNode(-1);
            ListNode temp;
            while (head != null) {
                temp = head.next;
                head.next = emptyHeader.next;
                emptyHeader.next = head;
                head = temp;
            }

            return emptyHeader.next;

        }
    }

    public static ListNode createMockList() {
        ListNode header = new ListNode(1);
        header.next = new ListNode(2);
        header.next.next = new ListNode(3);
        header.next.next.next = new ListNode(4);
        header.next.next.next.next = new ListNode(5);

        return header;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode header = createMockList();
        for (ListNode x = header; x != null; x = x.next) {
            System.out.print(x.val);
        }
        System.out.println("");
        header = solution.reverseList(header);

        for (ListNode x = header; x != null; x = x.next) {
            System.out.print(x.val);
        }
    }

}
