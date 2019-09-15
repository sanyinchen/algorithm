package leet_code.weekly_contest.weely_154;

import java.util.Stack;

/**
 * from https://leetcode-cn.com/contest/weekly-contest-154/problems/reverse-substrings-between-each-pair-of-parentheses/
 */

public class Reverse_Substrings_5190 {

    static class Solution {


        public String reverseParentheses(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }
            //  List<MutableInterface> queue = new ArrayList<>();
            Stack<Character> baseRecorder = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char item = s.charAt(i);
                System.out.println("==>" + s.charAt(i) + " i:" + i);
                if (item == ')') {
                    StringBuilder stringBuilder = new StringBuilder();
                    while (!baseRecorder.peek().equals('(')) {
                        stringBuilder.append(baseRecorder.pop());
                    }
                    baseRecorder.pop();

                    // System.out.println("=>" + stringBuilder.toString());
                    String temp = stringBuilder.toString();
                    for (int j = 0; j < temp.length(); j++) {
                        baseRecorder.push(temp.charAt(j));
                    }
                } else {
                    baseRecorder.push(item);
                }

            }
            StringBuilder res = new StringBuilder();
            while (!baseRecorder.empty()) {
                res.append(baseRecorder.pop());
            }
            return new StringBuilder(res).reverse().toString();

        }


    }

    public static void main(String[] args) {
        System.out.println("\nres==>" + (new Solution().reverseParentheses("wnb(((z()qw)eyt)(bx(()ye)))")));
    }
}
