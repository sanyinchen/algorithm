package leet_code;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by sanyinchen on 19-9-21.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-21
 */

class Plus_one_66 {
    static class Solution {

        public int[] plusOne(int[] digits) {
            if (digits == null) {
                return digits;
            }
            Stack<Integer> stack = new Stack<>();
            int step = 1;
            for (int i = digits.length - 1; i >= 0; i--) {
                int item = digits[i];
                item += step;
                stack.push(item % 10);
                step = item / 10;
            }
            if (step != 0) {
                stack.push(1);
            }
            List<Integer> list = new ArrayList<>();
            while (stack.size() != 0) {
                list.add(stack.pop());
            }
            // list = list.subList(list.size() - digits.length, digits.length);
            int[] res = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        for (int i : new Solution().plusOne(new int[]{9, 9, 9})) {
            System.out.print(i + " ");
        }
    }
}
