package leet_code;

import java.math.BigInteger;

/**
 * Created by sanyinchen on 19-10-25.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-25
 */

class add_strings_415 {
    class Solution {
        public String addStrings(String num1, String num2) {
            BigInteger bigInteger1 = new BigInteger(num1);
            BigInteger bigInteger2 = new BigInteger(num2);
            return bigInteger1.add(bigInteger2).toString();
        }
    }
}
