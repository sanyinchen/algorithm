package leet_code;

import java.util.ArrayList;
import java.util.List;

public class Longest_palindromic_substring_5 {
    static class Solution {
        private boolean isPalindromic(String content) {
            if (content.length() <= 1) {
                return true;
            }
            for (int i = 0, j = content.length() - 1; i < j; i++, j--) {
                if (content.charAt(i) != content.charAt(j)) {
                    return false;
                }
            }
            return true;
        }

        public String longestPalindrome(String str) {
            if (str == null || str.length() == 0) {
                return "";
            }
            List<String> strings = new ArrayList<>();
            strings.add(str.charAt(0) + "");
            String maxStr = strings.get(0);
            for (int i = 1; i < str.length(); i++) {
                char child = str.charAt(i);
                String newContent = strings.get(i - 1) + child;
                if (isPalindromic(newContent)) {
                    strings.add(newContent);
                    if (newContent.length() > maxStr.length()) {
                        maxStr = newContent;
                    }
                } else {
                    strings.add(child + "");
                }
            }
            return maxStr;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("babad"));
    }
}
