package leet_code.weekly_contest.weekly_157;


import java.util.ArrayList;
import java.util.List;

// todo fail
public class Stepping_numbers {
    static class Solution {
         private int max = 2000000000;
        // private int max = 2000;

        private int getStep(int number) {
            int old = number;
            int step = 1;
            while (number / 10 != 0) {
                step = step * 10 + 1;
                number /= 10;
            }
          //  System.out.println("number:" + old + " step:" + step);
            return step;
        }

        private int init(int number) {
            int step = 1;
            int old = number;
            while (number / 10 != 0) {
                step++;
                number /= 10;
            }
            int init = 0;
            int tempStep = 1;
            for (int i = step; i >=1; i--) {
                init += i * tempStep;
                tempStep *= 10;
            }
        //    System.out.println("number:" + old + "init:" + init);
            return init;
        }

        public List<Integer> countSteppingNumbers(int low, int high) {
            List<Integer> table = new ArrayList<>();
            for (int i = 0; i <= 10; i++) {
                table.add(i);
            }
            table.add(12);
            table.add(21);
            table.add(23);
            table.add(32);
            table.add(34);
            table.add(45);
            table.add(54);
            table.add(56);
            table.add(65);
            table.add(67);
            table.add(76);
            table.add(78);
            table.add(87);
            table.add(89);
            table.add(98);


            for (int i = 123; i <= max; ) {
                table.add(i);
                int step = getStep(i);
                i += step;
                String str = String.valueOf(i);
                if (str.charAt(str.length() - 1) == '0') {
                    i = init(i * 10);
                }
            }
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < table.size(); i++) {
                if (table.get(i) <= high && table.get(i) >= low) {
                    res.add(table.get(i));
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        List<Integer> res = new Solution().countSteppingNumbers(0, 100);

    }
}
