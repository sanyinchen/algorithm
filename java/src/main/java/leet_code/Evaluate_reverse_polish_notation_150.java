package leet_code;

import edu.princeton.cs.algs4.Stack;

/**
 * Created by sanyinchen on 20-1-7.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-1-7
 */

class Evaluate_reverse_polish_notation_150 {
    static class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> tokenStack = new Stack<>();
            for (String item : tokens) {
                if ("+".equals(item)) {
                    int b = tokenStack.pop();
                    int a = tokenStack.pop();
                    tokenStack.push(a + b);
                    continue;
                }
                if ("-".equals(item)) {
                    int b = tokenStack.pop();
                    int a = tokenStack.pop();
                    tokenStack.push(a - b);
                    continue;
                }
                if ("*".equals(item)) {
                    int b = tokenStack.pop();
                    int a = tokenStack.pop();
                    tokenStack.push(a * b);
                    continue;
                }
                if ("/".equals(item)) {
                    int b = tokenStack.pop();
                    int a = tokenStack.pop();
                    tokenStack.push(a / b);
                    continue;
                }
                tokenStack.push(Integer.parseInt(item));
            }
            return tokenStack.pop();
        }
    }
}
