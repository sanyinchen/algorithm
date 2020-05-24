package leet_code_part2;

/**
 * Created by sanyinchen on 20-5-24.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-5-24
 */

class Number_of_segments_in_a_string_434 {
    class Solution {
        public int countSegments(String s) {
            String[] words = s.trim().split(" ");
            int sum = 0;
            for (int i = 0; i < words.length; i++) {
                if (words[i].trim().length() != 0) {
                    sum++;
                }
            }
            return sum;
        }
    }
}
