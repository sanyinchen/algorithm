package leet_code;

/**
 * Created by sanyinchen on 19-10-24.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-24
 */

class Power_of_three_326 {
    class Solution {
        public boolean isPowerOfThree(int n) {
            if (n % 3 != 0) {
                return false;
            }
            if (n == 0) {
                return true;
            }
            return isPowerOfThree(n / 3);
        }
    }

}
