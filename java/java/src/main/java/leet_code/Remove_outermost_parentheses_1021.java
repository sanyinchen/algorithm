package leet_code;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by sanyinchen on 19-9-20.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-20
 */

class Remove_outermost_parentheses_1021 {
    static class Solution {
        public String removeOuterParentheses(String S) {
            List<String> list = new ArrayList<>();
            Stack<String> tempStack = new Stack<>();
            for (int i = 0; i < S.length(); i++) {
                if (S.charAt(i) == ')') {
                    String item = ")";
                    while (tempStack.size() != 0 && !tempStack.peek().equals("(")) {
                        item = tempStack.pop() + item;
                    }
                    item = tempStack.pop() + item;
                    tempStack.push(item);
                } else {
                    tempStack.push("(");
                }
            }
            String res = "";
            while (tempStack.size() != 0) {
                String temp = tempStack.pop();
                if (temp.length() <= 2) {
                    continue;
                }
                String newStr = temp.substring(1, temp.length() - 1);
                System.out.println(temp + " => " + newStr);
                res = newStr + res;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println("==>" + (new Solution().removeOuterParentheses("(()())(())(()(()))")));
    }
}
