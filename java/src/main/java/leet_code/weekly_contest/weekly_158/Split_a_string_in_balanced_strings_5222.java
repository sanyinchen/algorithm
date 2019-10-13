package leet_code.weekly_contest.weekly_158;

import edu.princeton.cs.algs4.Stack;

public class Split_a_string_in_balanced_strings_5222 {

    class Solution {
        public int balancedStringSplit(String s) {
            int sum = 0;
            Stack<Character> stack = new Stack<>();
            int match = 'R' + 'L';
            for (int i = 0; i < s.length(); i++) {
                if (!stack.isEmpty() && (s.charAt(i) + stack.peek() == match)) {
                    stack.pop();
                    if (stack.isEmpty()) {
                        sum++;
                    }
                } else {
                    stack.push(s.charAt(i));
                }
            }
            if (stack.isEmpty()) {
                return sum;
            }
            return 1;
        }
    }
}
