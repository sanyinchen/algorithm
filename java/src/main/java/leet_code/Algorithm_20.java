package leet_code;

import java.util.Stack;

/**
 * Created by sanyinchen on 19-9-10.
 * <p>
 * from https://leetcode-cn.com/problems/valid-parentheses/
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-10
 */

class Algorithm_20 {

    public static boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        // ()
        Stack<Character> parenthese = new Stack<Character>();
        // []
        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            if (item == '(') {
                if (parenthese.size() != 0 && parenthese.peek() == ')') {
                    parenthese.pop();
                } else {
                    parenthese.push(item);
                }
            }

            if (item == ')') {
                if (parenthese.size() != 0 && parenthese.peek() == '(') {
                    parenthese.pop();
                } else {
                    parenthese.push(item);
                }
            }

            if (item == '{') {
                if (parenthese.size() != 0 && parenthese.peek() == '}') {
                    parenthese.pop();
                } else {
                    parenthese.push(item);
                }
            }

            if (item == '}') {
                if (parenthese.size() != 0 && parenthese.peek() == '{') {
                    parenthese.pop();
                } else {
                    parenthese.push(item);
                }
            }


            if (item == '[') {
                if (parenthese.size() != 0 && parenthese.peek() == ']') {
                    parenthese.pop();
                } else {
                    parenthese.push(item);
                }
            }

            if (item == ']') {
                if (parenthese.size() != 0 && parenthese.peek() == '[') {
                    parenthese.pop();
                } else {
                    parenthese.push(item);
                }
            }

        }

        return parenthese.size() == 0;

    }


    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
    }
}
