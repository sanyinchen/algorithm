package leet_code;

/**
 * Created by sanyinchen on 19-10-12.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-12
 */

class Reverse_words_in_a_string_iii_557 {
    class Solution {
        public String reverseWords(String s) {
            String[] strs = s.split(" ");
            StringBuilder str = new StringBuilder();
           // int length = strs.length;
            for (int i = 0; i < strs.length; i++) {
                String temp = strs[i];
                if (temp.length() == 0) {
                    continue;
                }

                for (int j = temp.length() - 1; j >= 0; j--) {
                    str.append(temp.charAt(j));
                }
                if (i != strs.length - 1) {
                    str.append(" ");
                }

            }
            return str.toString();
        }
    }
}
