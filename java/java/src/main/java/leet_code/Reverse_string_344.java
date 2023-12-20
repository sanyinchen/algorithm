package leet_code;

public class Reverse_string_344 {
    static class Solution {
        private void reverseString(char[] s, int l) {
            if (l < 0) {
                return;
            }
            reverseString(s, l - 1);
            char temp = s[l];
            s[l] = s[s.length - l - 1];
            s[s.length - l - 1] = temp;

        }

        public void reverseString(char[] s) {
            if (s == null || s.length == 0) {
                return;
            }
            reverseString(s, s.length / 2 - 1);
        }
    }

    public static void main(String[] args) {
        char[] test = new char[]{'a', 'b', 'c', 'd', 'e'};
        new Solution().reverseString(test);
        for (char c : test) {
            System.out.print(c + " ");
        }
    }
}
