package leet_code;

/**
 * Created by sanyinchen on 19-10-24.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-24
 */

class Power_of_three_326 {
    public static class Solution {
        public boolean isPowerOfThree(int n) {
            // System.out.println(n);
            if (n == 1) {
                return true;
            }
            if (n % 3 != 0 || n <= 0) {
                return false;
            }

            return isPowerOfThree(n / 3);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfThree(27));
    }

}
