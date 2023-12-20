package leet_code;

/**
 * Created by sanyinchen on 19-10-14.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-14
 */

class Number_of_1_bits_191 {
    public class Solution {
        public int hammingWeight(int n) {
            String str = Integer.toBinaryString(n);
            int sum = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '1') {
                    sum++;
                }
            }
            return sum;
        }
    }
}
