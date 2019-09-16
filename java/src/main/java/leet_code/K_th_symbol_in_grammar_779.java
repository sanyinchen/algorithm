package leet_code;

import java.util.List;

/**
 * Created by sanyinchen on 19-9-16.
 * <p>
 * from https://leetcode-cn.com/problems/k-th-symbol-in-grammar/
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-16
 */

class K_th_symbol_in_grammar_779 {
    static class Solution {
        private String kthGrammarCreate(int n) {
            if (n == 1) {
                return "0";
            }
            String str = kthGrammarCreate(n - 1);
            System.out.println("str:" + str + " :" + str.length());
            StringBuilder newStringBuilder = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0') {
                    newStringBuilder.append("01");
                } else {
                    newStringBuilder.append("10");
                }
            }
            return newStringBuilder.toString();
        }

        public int kthGrammar(int N, int K) {
            String str = kthGrammarCreate(N);
            if (K > str.length()) {
                throw new RuntimeException("error");
            }
            System.out.println("str:" + str + " " + str.length());
            return Integer.valueOf(str.charAt(K - 1) + "");
        }
    }

    public static void main(String[] args) {
        System.out.println("==>" + new Solution().kthGrammar(10, 5));
    }
}
