package leet_code;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sanyinchen on 19-10-14.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-14
 */

class Count_and_say_38 {
    static class Solution {

        private String countAndSayHelper(int max, int cur, String str) {
            if (cur == max) {
                return str;
            }
            StringBuilder stringBuilder = new StringBuilder();
            int sum = 1;
            if (str.length() >= 2) {
                for (int i = 1; i < str.length(); i++) {
                    char temp = str.charAt(i);
                    if (temp == str.charAt(i - 1)) {
                        sum++;
                        if (str.length() == i + 1) {
                            stringBuilder.append(sum).append(str.charAt(i - 1));
                        }
                    } else {
                        stringBuilder.append(sum).append(str.charAt(i - 1));
                        sum = 1;
                        if (str.length() == i + 1) {
                            stringBuilder.append(sum).append(str.charAt(i));
                        }
                    }

                }
            } else {
                stringBuilder.append("1").append(str.charAt(0));
            }
            System.out.println("==> cur" + (cur + 1) + " : " + stringBuilder.toString());
            return countAndSayHelper(max, cur + 1, stringBuilder.toString());
        }

        public String countAndSay(int n) {

            return countAndSayHelper(n, 1, "1");
        }
    }

    public static void main(String[] args) {
        System.out.println("==>" + new Solution().countAndSay(6));
    }
}
