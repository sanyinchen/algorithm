package leet_code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by sanyinchen on 19-9-12.
 * <p>
 * from https://leetcode-cn.com/problems/strobogrammatic-number-ii/
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-12
 */

class Recursive_247 {

    static class Solution {


        private boolean vaildAble(char number) {

            return number == '0' || number == '1' || number == '8';
        }

        private boolean endvaildAble(int number) {
            if (number < 10) {
                return true;
            }
            while (number / 10 != 0) {
                int end = number % 10;
                if (!(end == 0 || end == 1 || end == 8 || end == 6 || end == 9)) {
                    return false;
                }
                number /= 10;
            }
            return true;
        }

        private boolean vaildAble(char left, char right) {
            if (left == right) {
                return vaildAble(left);
            } else {
                return (left == '6' && right == '9') || (left == '9' && right == '6');
            }
        }

        private String getNumberScop(int start, int end, String number) {
            if (number.length() == 1) {
                return number;
            }
            if (start == end) {
                return number.charAt(start) + "";
            }
            if (start > end) {
                return "";
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = start; i <= end; i++) {
                stringBuilder.append(number.charAt(i));
            }
            return stringBuilder.toString();
        }

        private boolean strobogrammaticAble(int start, int end, String number) {


            if (start == end) {
                return vaildAble(number.charAt(start));
            }
            if (start > end) {
                return true;
            }

            return vaildAble(number.charAt(start), number.charAt(end)) && strobogrammaticAble(start + 1, end - 1,
                    number);


        }

//        private boolean strobogrammaticAble(String number) {
//            int length = number.length();
//            if (length == 1) {
//                return vaildAble(number.charAt(0));
//            }
//            if (length == 0) {
//                return true;
//            }
//
//            if (cache.containsKey(number)) {
//
//                return cache.get(number);
//            }
//            boolean res = true;
//            if (length % 2 != 0) {
//                char midChar = number.charAt(length / 2);
//                // System.out.println(number + " " + midChar + " mid:" + (length / 2 - 1) + " length / 2 " + (length /
//                // 2) + " length:" + length);
//                res = vaildAble(midChar);
//            }
//            if (res) {
//                res = strobogrammaticAble(0, number.length() - 1, number);
//            }
//            cache.put(number, res);
//            return res && strobogrammaticAble(getNumberScop(1, number.length() - 2, number));
//        }

        private boolean pareFilter(String number) {
            return number.contains("2")
                    || number.contains("3")
                    || number.contains("4")
                    || number.contains("5")
                    || number.contains("7");
        }

        private static boolean pareFilter2(String number) {
            if (number.length() <= 2) {
                return false;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < number.length(); i++) {
                if (number.charAt(i) == '9') {
                    stringBuilder.append('6');
                } else {
                    stringBuilder.append(number.charAt(i));
                }
            }
            int mid = number.length() / 2;
            String left = number.substring(0, mid);
            String right = number.substring(mid + 1);
            return !left.equals(right);

        }


        public List<String> findStrobogrammatic(int n) {
            int start = 1;
            for (int i = 1; i < n; i++) {
                start *= 10;
            }
           // long time1 = System.currentTimeMillis();
            int end = start * 10 - 1;
            List<Integer> numberList = new ArrayList<>();
            if (n == 1) {
                start = 0;
            }
            for (int i = start; i <= end; i++) {
                if (endvaildAble(i)) {
                    numberList.add(i);
                }
            }
           // System.out.println("numberList:" + numberList.size());
            // long time2 = System.currentTimeMillis();
           // System.out.println("cost1:" + (time2 - time1));
            List<String> res = new ArrayList<>();
            for (int i = 0; i < numberList.size(); i++) {
                String item = numberList.get(i) + "";
               // long time3 = System.currentTimeMillis();

                if (strobogrammaticAble(0, item.length() - 1, item)) {
                    res.add(item);
                }
                // System.out.println("item:" + item + " time1:" + time3 + " time2:" + System.currentTimeMillis());
                // System.out.println("item coast:" + (System.currentTimeMillis() - time3));
            }

            // System.out.println("cost2:" + (System.currentTimeMillis() - time2));
            return res;
        }
    }


    public static void main(String[] args) {
        long time1 = System.currentTimeMillis();
        Solution solution = new Solution();

        solution.findStrobogrammatic(2).forEach((item) -> {
            System.out.print(item + " ");
        });
        System.out.println();
        solution.findStrobogrammatic(3).forEach((item) -> {
            System.out.print(item + " ");
        });
        System.out.println();
        solution.findStrobogrammatic(4).forEach((item) -> {
            System.out.print(item + " ");
        });
        System.out.println();
        System.out.println(System.currentTimeMillis() - time1);
    }
}
