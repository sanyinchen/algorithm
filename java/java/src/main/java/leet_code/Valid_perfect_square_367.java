package leet_code;

import java.math.BigInteger;

public class Valid_perfect_square_367 {
    static class Solution {
        private boolean isValid(int target, int l, int r) {
            if (l > r) {
                return false;
            }
            int mid = (l + r) >>> 1;
            System.out.println("mid:" + mid + " l:" + l + " r:" + r);
            BigInteger midBig = new BigInteger(mid + "");
            BigInteger sum = midBig.multiply(midBig);
            if (target == sum.intValue()) {
                return true;
            }
            if (sum.compareTo(new BigInteger(target + "")) > 0) {
                return isValid(target, l, mid - 1);
            } else {
                return isValid(target, mid + 1, r);
            }
        }

        public boolean isPerfectSquare(int num) {
            if (num == 0) {
                return false;
            }
            if (num == 1) {
                return true;
            }
            return isValid(num, 1, num/2);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPerfectSquare(808201));
        System.out.println(Math.sqrt(808201));
    }
}
