package leet_code;

/**
 * Created by sanyinchen on 19-10-14.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-14
 */

class Valid_palindrome_125 {
    static class Solution {
        boolean isValid(char temp) {
            return (temp <= 'Z' && temp >= 'A' || temp <= '9' && temp >= '0' || temp >= 'a' && temp <= 'z');
        }

        public boolean isPalindrome(String s) {
            for (int i = 0, j = s.length() - 1; i <= j; ) {
                char temp = s.charAt(i);
                char temp2 = s.charAt(j);
                if (!isValid(temp)) {
                    i++;
                    continue;
                }
                if (!isValid(temp2)) {
                    j--;
                    continue;
                }
             //   System.out.println("==>" + temp + " " + temp2);
                if (!("" + temp).toLowerCase().equals(("" + temp2).toLowerCase())) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println("==>" + new Solution().isPalindrome("A man, a plan, a canal: Panama"));
    }
}
