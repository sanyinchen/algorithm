package leet_code_part2;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sanyinchen on 20-6-9.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-6-9
 */

class Ba_shu_zi_fan_yi_cheng_zi_fu_chuan_lcof_46 {
    static class Solution {

        Set<String> cache = new HashSet<>();

        private String getChar(String num) {
            if (num.length() == 0) {
                return "";
            }
            return ((char) (Integer.parseInt(num) + 'a')) + "";
        }

        private String subString(String str, int end) {
            if (str == null || str.length() == 0 || str.length() <= end) {
                return "";
            }
            return str.substring(end);
        }

        private void translateNumHelper(String num, String str) {
            if (num.length() <= 1) {
                cache.add(str + getChar(num));
                return;
            }
            translateNumHelper(subString(num, 1), str + getChar(num.substring(0, 1)));
            String temp = num.substring(0, 2);
            int tempInt = Integer.parseInt(temp);
            if (tempInt <= 25 && tempInt >= 10) {
                translateNumHelper(subString(num, 2), str + getChar(temp));
            }
        }

        public int translateNum(int num) {
            translateNumHelper(num + "", "");
            for (String item : cache) {
                System.out.println(item);
            }
            return cache.size();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int test1 = 12258;
        System.out.println(solution.translateNum(test1));
    }
}
