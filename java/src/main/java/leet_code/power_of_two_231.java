package leet_code;

/**
 * Created by sanyinchen on 19-10-25.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-25
 */

class power_of_two_231 {
    class Solution {
        public boolean isPowerOfTwo(int n) {
            return n >= 1 && ((n & (n - 1)) == 0);
        }
    }

}
