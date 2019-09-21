package leet_code;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sanyinchen on 19-9-20.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-20
 */

class Longest_substring_without_repeating_characters_3 {
    static class Solution {
        Set<Character> cache = new HashSet<>();

        private void lengthOfLongestSubstringHelper(String s, int start, int step) {
            if (start + step >= s.length()) {
                return;
            }
            if (start != -1) {
                System.out.println("start:" + start + " step:" + step + " " + s.substring(start, start + step));

            }
            for (int i = 1; i < s.length(); i++) {
                lengthOfLongestSubstringHelper(s, start + 1, i);
            }

            //  System.out.println("==>" + max + " " + s.charAt(i));
//            if (cache.contains(s.charAt(i))) {
//                return max;
//            }
//            cache.add(s.charAt(i));
            return;

        }

        public int lengthOfLongestSubstring(String s) {
            if (s == null) {
                return 0;
            }
            if (s.length() <= 1) {
                return s.length();
            }
            cache.clear();
            lengthOfLongestSubstringHelper(s, -1, 1);
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abc"));
    }
}
