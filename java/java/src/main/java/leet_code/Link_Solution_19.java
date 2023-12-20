package leet_code;

/**
 * Created by sanyinchen on 19-9-11.
 * <p>
 * from https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-11
 */

class Link_Solution_19 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            int length = 0;
            ListNode oldHead = head;
            for (ListNode index = head; index != null; index = index.next) {
                length++;
            }
            int i = 0;
            int delIndex = length - n;
            if (delIndex - 1 < 0) {
                oldHead = oldHead.next;
                return oldHead;
            }
            System.out.println("delIndex:" + delIndex);
            ListNode tempNode = null;
            for (ListNode index = oldHead; index != null && i < delIndex; index = index.next) {
                tempNode = index;
                System.out.println("tempNode:" + tempNode.val);
                i++;
            }
            if (tempNode != null && tempNode.next != null) {
                tempNode.next = tempNode.next.next;
            }


            return oldHead;
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
        header = solution.removeNthFromEnd(header, 2);

        for (ListNode x = header; x != null; x = x.next) {
            System.out.print(x.val);
        }
    }

}
