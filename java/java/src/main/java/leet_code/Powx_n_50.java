package leet_code;

/**
 * Created by sanyinchen on 19-9-18.
 * <p>
 * from https://leetcode-cn.com/problems/powx-n/
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-18
 */

class Powx_n_50 {
    static class Solution {
        private double myPowHelper(double x, int n) {
            double sum = x;
            int number = 0;
            for (int i = 1; i < n; i++) {
                sum *= x;
                if (Double.compare(sum, 0.0000001) < 0) {
                    number++;
                }
                if (number >= 52) {
                    return 0.0f;
                }
            }
            return sum;
        }


        private boolean isNegativeNumber(double x, int n) {
            return n % 2 != 0 && Double.compare(x, 0.0) < 0;
        }

        public double myPow(double x, int n) {
            if (n == 0 || x == 1) {
                return 1;
            }
            if (x == -1) {
                return isNegativeNumber(x, n) ? -1 : 1;
            }
            if (n == Integer.MIN_VALUE) {
                return 0.0;
            }
            if (n < 0) {
                return isNegativeNumber(x, n) ? 0 - 1.0 / myPowHelper(Math.abs(x), Math.abs(n)) :
                        1.0 / myPowHelper(Math.abs(x),
                                Math.abs(n));
            }
            return isNegativeNumber(x, n) ? 0 - myPowHelper(Math.abs(x), n) : myPowHelper(Math.abs(x), n);
        }
    }

    public static void main(String[] args) {


        System.out.println(new Solution().myPow(2, -2147483648));
    }
}
