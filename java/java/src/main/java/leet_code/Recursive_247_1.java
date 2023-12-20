package leet_code;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanyinchen on 19-9-12.
 * <p>
 * from https://leetcode-cn.com/problems/strobogrammatic-number-ii/
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-12
 */

class Recursive_247_1 {

    static class Solution {

        private static final List<String> F1 = new ArrayList<>();
        private static final List<String> F2 = new ArrayList<>();

        static {
            F1.add("0");
            F1.add("1");
            F1.add("8");

            F2.add("00");
            F2.add("11");
            F2.add("69");
            F2.add("88");
            F2.add("96");

        }

        private String stringMix(String str1, String str2) {
            StringBuilder stringBuilder = new StringBuilder();
            int str1Length = str1.length();
            if (str1Length % 2 != 0) {
                throw new RuntimeException("str1's lenght %2 !=0");
            }
            int mid = str1Length / 2;
            String left = str1.substring(0, mid);
            String right = str1.substring(mid);
            return stringBuilder.append(left).append(str2).append(right).toString();

        }

        private List<String> listMix(List<String> mix1, List<String> mix2) {
            List<String> tempList = new ArrayList<>();
            for (String item1 : mix1) {
                for (String item2 : mix2) {
                    tempList.add(stringMix(item1, item2));
                }
            }
            return tempList;
        }

        private List<String> numberMix(int n) {
            if (n == 1) {
                return F1;
            }
            if (n == 2) {
                return F2;
            }
            if (n % 2 == 0) {
                return listMix(numberMix(n - 2), numberMix(2));
            } else {
                return listMix(numberMix(n - 1), F1);
            }


        }


        public List<String> findStrobogrammatic(int n) {
            if (n == 1) {
                return F1;
            }

            List<String> numberMisList = numberMix(n);
            List<String> resList = new ArrayList<>();
            for (String item : numberMisList) {
                if (!item.startsWith("0")) {
                    resList.add(item);
                }
            }
            return resList;
        }
    }


    public static void main(String[] args) {
        long time1 = System.currentTimeMillis();
        Solution solution = new Solution();

        int size=solution.findStrobogrammatic(5).size();
        System.out.println("size:"+size);
//        System.out.println();
//        solution.findStrobogrammatic(3).forEach((item) -> {
//            System.out.print(item + " ");
//        });
//        System.out.println();
//        solution.findStrobogrammatic(4).forEach((item) -> {
//            System.out.print(item + " ");
//        });
        System.out.println();
        System.out.println(System.currentTimeMillis() - time1);
    }
}
