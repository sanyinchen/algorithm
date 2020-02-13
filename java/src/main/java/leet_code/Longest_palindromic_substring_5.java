package leet_code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Longest_palindromic_substring_5 {
    static class Solution {
        public String longestPalindrome(String str) {
            if (str == null || str.length() == 0) {
                return "";
            }
            if (str.length() == 1) {
                return str;
            }
            boolean[][] dp = new boolean[str.length()][str.length()];
            for (int i = 0; i < str.length(); i++) {
                dp[i][i] = true;
            }
            int maxLen = 1;
            String res = str.charAt(0) + "";
            for (int i = 1; i < str.length(); i++) {
                for (int j = 0; j <= i - 1; j++) {
                    if (j + 1 >= i - 1) {
                        dp[j][i] = (str.charAt(i) == str.charAt(j));
                    } else {
                        dp[j][i] = (dp[j + 1][i - 1] && (str.charAt(i) == str.charAt(j)));
                    }
                    if (dp[j][i] && ((i - j + 1) > maxLen)) {
                        maxLen = (i - j) + 1;
                        res = str.substring(j, i + 1);
                    }
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("ac"));
    }
}
