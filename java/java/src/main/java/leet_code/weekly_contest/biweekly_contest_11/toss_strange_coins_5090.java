package leet_code.weekly_contest.biweekly_contest_11;

import java.math.BigInteger;
import java.util.Arrays;

// todo fail
public class toss_strange_coins_5090 {
    static class Solution {

        private double getSingle(double[] prob, int start, int end, int target) {
            if (end > prob.length) {
                return 0;
            }
            BigInteger res = BigInteger.ONE;
            BigInteger step = BigInteger.ONE;
            int max = 1000000;
            for (int i = start; i < end; i++) {
                double tempItem = prob[i] * (double) max;
                if (target == 0) {
                    tempItem = (1 - prob[i]) * (double) max;
                }
                step = step.multiply(new BigInteger(max + ""));
                res = res.multiply(new BigInteger((int) tempItem + ""));
            }

            return res.doubleValue() / step.doubleValue();
        }

        public double probabilityOfHeads(double[] prob, int target) {
            Arrays.sort(prob);
            if (target == 0) {
                return getSingle(prob, 0, prob.length, 0);
            }
            if (target >= prob.length) {
                return 0;
            }
            double res = 0;
            double step = 0;
            for (int i = 0; i < prob.length; i += target) {
                double mid = getSingle(prob, i, i + target, 1);
                double start = getSingle(prob, 0, i + 1, 0);
                double end = getSingle(prob, i + target - 1, prob.length, 0);
                res += (mid + start + end);
                System.out.println("start:" + start + " mid:" + mid + " end:" + end);
                step++;
            }
            return res / step;
        }
    }

    public static void main(String[] args) {
        double[] input = new double[]{0.2, 0.8, 0, 0.3, 0.5};
        System.out.println("==>" + new Solution().probabilityOfHeads(input, 3));
    }
}
