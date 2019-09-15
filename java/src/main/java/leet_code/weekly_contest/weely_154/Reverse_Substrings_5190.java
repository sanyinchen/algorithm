package leet_code.weekly_contest.weely_154;

import java.util.Stack;

/**
 *
 * from https://leetcode-cn.com/contest/weekly-contest-154/problems/reverse-substrings-between-each-pair-of-parentheses/
 *
 */

public class Reverse_Substrings_5190 {

    static class Solution {

        public String singleReverseParentheses(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }
            if (s.equals("()")) {
                return "()";
            }

            int leftIndex = s.indexOf('(');
            int rightIndex = s.lastIndexOf(')');
//            for (int i = leftIndex + 1, j = s.length() - 1; i < j && i > 0; j--) {
//                if (s.charAt(j) == ')') {
//                    rightIndex = j;
//                }
//            }

            if (leftIndex == -1 || rightIndex == -1) {
                return new StringBuilder(s).reverse().toString();
            }
            System.out.println("s " + s + " leftIndex:" + leftIndex + " rightIndex:" + rightIndex);
            String subStr = s.substring(leftIndex + 1, rightIndex);
            System.out.println("substr==>" + subStr);
            String res = singleReverseParentheses(subStr);
            System.out.println("reverse==>" + new StringBuilder(s.replace("(" + subStr + ")", res)).reverse()
                    .toString());
            return new StringBuilder(s.replace("(" + subStr + ")", res)).reverse().toString();
        }

        public String reverseParentheses(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }
            int leftIndex = s.indexOf('(');
            int rightIndex = -1;
            StringBuilder stringBuilder = new StringBuilder();
            if (leftIndex == -1) {
                return s;
            }
            stringBuilder.append(s, 0, leftIndex);
            Stack<Character> stacks = new Stack<>();
            StringBuilder temp = new StringBuilder();
            while (leftIndex != -1) {


                for (int i = leftIndex; i < s.length(); i++) {
                    char flag = s.charAt(i);
                    if (flag == '(') {
                        stacks.push(flag);
                        temp.append(flag);
                    }
                    if (flag == ')') {
                        stacks.pop();
                        temp.append(flag);
                    }
                    if (stacks.size() != 0 && flag != '(' && flag != ')') {
                        System.out.print(flag);
                        temp.append(flag);
                    }
                    if (stacks.size() == 0) {
                        StringBuilder subStr = new StringBuilder();
                        subStr.append(temp);
                        StringBuilder reversubStr =
                                new StringBuilder(singleReverseParentheses(subStr.toString())).reverse();
                        System.out.println("subStr:" + subStr + " reversubStr:" + reversubStr);

                        stringBuilder.append(reversubStr);
                        temp.delete(0, temp.length());
                        rightIndex = i;
                        break;
                    }
                }
                leftIndex = -1;
                for (int i = rightIndex + 1; i < s.length(); i++) {
                    if (s.charAt(i) == '(') {
                        leftIndex = i;
                    } else {
                        stringBuilder.append(s.charAt(i));
                    }
                }
            }
            //  System.out.println(stringBuilder);
//            while (leftIndex != -1) {
//                for (int i = leftIndex + 1, j = s.length() - 1; i < j; j--) {
//
//                    if (s.charAt(j) == ')') {
//                        rightIndex = j;
//                    }
//                }
//                System.out.println("leftIndex:" + leftIndex);
//                System.out.println("rightIndex:" + rightIndex);
//                System.out.println("subStr:" + s.substring(leftIndex, rightIndex + 1));
//                stringBuilder.append(new StringBuilder(singleReverseParentheses(s.substring(leftIndex,
//                        rightIndex + 1))).reverse().toString());
//                leftIndex = -1;
//                for (int i = rightIndex + 1; i < s.length() - 1; i++) {
//                    if (s.charAt(i) == '(') {
//                        leftIndex = i;
//                    } else {
//                        stringBuilder.append(s.charAt(i));
//                    }
//                }
//
//            }
            //return "";
            return reverseParentheses(stringBuilder.toString());
//            String finalRes = singleReverseParentheses(s);
//            System.out.println("final==>" + finalRes);
//
//            return new StringBuilder(finalRes).reverse().toString();
        }
    }

    public static void main(String[] args) {
        System.out.println("\nres==>" + (new Solution().reverseParentheses("wnb(((z()qw)eyt)(bx(()ye)))")));
    }
}
