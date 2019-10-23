package leet_code;

/**
 * Created by sanyinchen on 19-10-23.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-23
 */

class Roman_to_integer_13 {
    class Solution {

        private int getSpecial(String v) {
            switch (v) {
                case "IV":
                    return 4;
                case "IX":
                    return 9;
                case "XL":
                    return 40;
                case "XC":
                    return 90;
                case "CD":
                    return 400;
                case "CM":
                    return 900;
                default:
                    return -1;
            }
        }

        private int getNormal(String v) {
            switch (v) {
                case "I":
                    return 1;
                case "V":
                    return 5;
                case "X":
                    return 10;
                case "L":
                    return 50;
                case "C":
                    return 100;
                case "D":
                    return 500;
                case "M":
                    return 1000;
                default:
                    return -1;
            }
        }

        public int romanToInt(String s) {
            int sum = 0;
            for (int i = 0; i < s.length(); ) {
                int temp = -1;
                if ((i + 1) < s.length()) {
                    temp = getSpecial("" + s.charAt(i) + s.charAt(i + 1));
                    if (temp != -1) {
                        i += 2;
                    }
                }
                if (temp == -1) {
                    temp = getNormal("" + s.charAt(i));
                    if (temp != -1) {
                        i += 1;
                    }
                }
                if (temp == -1) {
                    throw new RuntimeException("error in " + i);
                }
                sum += temp;
            }
            return sum;
        }
    }
}
