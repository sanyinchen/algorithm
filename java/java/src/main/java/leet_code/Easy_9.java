package leet_code;

public class Easy_9 {
    class Solution {
        public boolean isPalindrome(int x) {
            String str = x + "";
            for (int i = 0, j = str.length() - 1; i < str.length() && i <= j; i++, j--) {
                if (str.charAt(i) != str.charAt(j)) {
                    return false;
                }
            }
            return true;
        }
    }
}
