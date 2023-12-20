package leet_code;

public class Find_smallest_letter_greater_than_target_744 {
    class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            for (int i = 0; i < letters.length; i++) {
                if (target >= letters[i]) {
                    return letters[i];
                }
            }
            return letters[0];
        }
    }
}
