package leet_code;

import java.math.BigInteger;

/**
 * Created by sanyinchen on 19-10-14.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-14
 */

class String_to_integer_atoi_8 {
    static class Solution {
        public int myAtoi(String str) {
            if (str == null || str.length() == 0) {
                return 0;
            }
            String number = str.trim();
            StringBuilder vaildNumber = new StringBuilder();
            for (int i = 0; i < number.length(); i++) {
                char temp = number.charAt(i);
                if ((temp == '-' || temp == '+') && i == 0) {
                    vaildNumber.append(temp);
                    continue;
                }
                if ((temp <= '9' && temp >= '0')) {
                    vaildNumber.append(temp);
                    continue;
                }
                break;
            }
            if ((vaildNumber.toString().equals("-") || vaildNumber.toString().equals("+")) || vaildNumber.toString().length() == 0) {
                return 0;
            }
            BigInteger bigInteger = new BigInteger(vaildNumber.toString());
            BigInteger maxbig = new BigInteger(Integer.MAX_VALUE + "");
            BigInteger minbig = new BigInteger(Integer.MIN_VALUE + "");

            if (bigInteger.compareTo(minbig) <= 0) {
                return Integer.MIN_VALUE;
            }
            if (bigInteger.compareTo(maxbig) >= 0) {
                return Integer.MAX_VALUE;
            }
            return bigInteger.intValue();
        }
    }

    public static void main(String[] args) {
        System.out.println("==>" + new Solution().myAtoi("   +0 123"));
    }
}
