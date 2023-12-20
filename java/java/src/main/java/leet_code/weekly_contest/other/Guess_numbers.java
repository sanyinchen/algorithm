package leet_code.weekly_contest.other;

/**
 * Created by sanyinchen on 19-9-24.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-24
 */

class Guess_numbers {
    class Solution {
        public int game(int[] guess, int[] answer) {
            int num = 0;
            for (int i = 0; i < guess.length; i++) {
                if (guess[i] == answer[i]) {
                    num++;
                }
            }
            return num;
        }
    }
}
