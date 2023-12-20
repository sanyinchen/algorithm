package leet_code;

import java.math.BigInteger;

/**
 * Created by sanyinchen on 19-9-11.
 * <p>
 * from https://leetcode-cn.com/problems/reverse-integer/
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-11
 */

class Simple_7 {

    static class Solution {
        public int reverse(int x) {
            BigInteger finalRes;
            String oldStr = (x + "");
            StringBuilder newStr = new StringBuilder();

            for (int i = oldStr.length() - 1; i >= 0; i--) {
                if (oldStr.charAt(i) == '-') {
                    continue;
                }
                newStr.append(oldStr.charAt(i));
            }

            System.out.println("new str:" + newStr);
            finalRes = new BigInteger(newStr.toString());

            finalRes = x < 0 ? BigInteger.ZERO.subtract(finalRes) : finalRes;
            System.out.println("finalRes:" + finalRes);

            if (finalRes.compareTo(new BigInteger(finalRes.intValue() + "")) != 0) {
                return 0;
            }

            // return (int) finalRes;
            return finalRes.intValue();

        }
    }


    public static void main(String[] args) {
        int x = new Solution().reverse(-10);
        if (x > 0) {
            System.out.println(x);
        } else {
            System.out.println("=>" + x);

        }
    }
}
