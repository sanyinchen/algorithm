package leet_code;

import java.math.BigInteger;

/**
 * Created by sanyinchen on 19-9-14.
 * <p>
 * from https://leetcode-cn.com/problems/add-two-numbers-ii/
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-14
 */

class Add_Two_Numbers_ii_445 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {

        private BigInteger link2BigNumber(ListNode l1) {
            if (l1 == null) {
                return BigInteger.ZERO;
            }
            ListNode emptyHead = new ListNode(-1);
            ListNode head = l1;
            while (head != null) {
                ListNode temp = head.next;
                head.next = emptyHead.next;
                emptyHead.next = head;
                head = temp;
            }
            BigInteger step = BigInteger.TEN;
            emptyHead = emptyHead.next;
            BigInteger number = new BigInteger(emptyHead.val + "");
            while (emptyHead.next != null) {
                number = number.add(new BigInteger(emptyHead.next.val + "").multiply(step));
                step = step.multiply(BigInteger.TEN);
                emptyHead = emptyHead.next;
            }

            return number;
        }

        private ListNode bigNumber2Link(BigInteger sum) {
            ListNode emptyHead = new ListNode(-1);
            emptyHead.next = new ListNode(sum.remainder(BigInteger.TEN).intValue());
            while ((sum = sum.divide(BigInteger.TEN)).compareTo(BigInteger.ZERO) != 0) {
                ListNode newNode = new ListNode(sum.remainder(BigInteger.TEN).intValue());
                ListNode oldNext = emptyHead.next;
                emptyHead.next = newNode;
                newNode.next = oldNext;
            }
            return emptyHead.next;
        }

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            BigInteger first = link2BigNumber(l1);
            BigInteger second = link2BigNumber(l2);
            BigInteger sum = first.add(second);

            System.out.println("first:" + first);
            System.out.println("second:" + second);
            System.out.println("sum:" + sum);

            return bigNumber2Link(sum);
        }
    }

    public static ListNode createMockList1() {
        ListNode header = new ListNode(7);
        header.next = new ListNode(2);
        header.next.next = new ListNode(4);
        header.next.next.next = new ListNode(3);

        return header;

    }

    public static ListNode createMockList2() {
        ListNode header = new ListNode(5);
        header.next = new ListNode(6);
        header.next.next = new ListNode(4);
        return header;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode mock1 = createMockList1();
        ListNode mock2 = createMockList2();

        System.out.println("");
        ListNode header = solution.addTwoNumbers(mock1, mock2);

        for (ListNode x = header; x != null; x = x.next) {
            System.out.print(x.val);
        }
    }
}
