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

        private int kthGrammar(long N, long K) {
            if (N == 0) {
                return 0;
            }
            long number = 2 << (N - 1);
            if (K <= number / 2) {
                return kthGrammar(N - 1, K);
            } else {
                return 1^kthGrammar(N, K - number / 2);
            }

        }

        public int kthGrammar(int N, int K) {
            if (N == 1) {
                return 0;
            }
            return kthGrammar((long) N - 1, (long) K);
        }
    }

    public static void main(String[] args) {
        // long sum = 2 << 29;
        // System.out.println("sum:" + sum);
        int a = 0b1;
        //System.out.println(~(~(a)));
        System.out.println("==>" + new Solution().kthGrammar(2, 1));
    }
}
