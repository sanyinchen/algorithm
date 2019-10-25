package leet_code;

/**
 * Created by sanyinchen on 19-10-25.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-25
 */

class Power_of_four_342 {
    class Solution {
        public boolean isPowerOfFour(int n) {
            if (n == 1) {
                return true;
            }
            if (n % 4 != 0 || n <= 0) {
                return false;
            }

            return isPowerOfFour(n / 4);
        }
    }
}
