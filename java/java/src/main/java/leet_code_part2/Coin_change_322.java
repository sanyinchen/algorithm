package leet_code_part2;



import java.util.*;

/**
 * Created by sanyinchen on 20-3-11.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-3-11
 */

class Coin_change_322 {
    static class Solution {
        private int min = Integer.MAX_VALUE;

        void GetMinCoinCountOfValueHelper(int total, Integer[] values, int valueIndex, int valueCount, int sum) {
            if (total == 0) {
                min = Math.min(sum, min);
                return;
            }

            if (valueIndex == valueCount || total < 0) {
                return;
            }

            int currentValue = values[valueIndex];
            int maxCount = total / currentValue;

            for (int count = maxCount; count >= 0 && (count + sum) < min; count--) {
                int rest = total - count * currentValue;
                if (rest < 0) {
                    continue;
                }

                GetMinCoinCountOfValueHelper(rest, values, valueIndex + 1, valueCount, sum + count);
            }

        }


        public int coinChange(int[] coins, int amount) {
            if (coins.length == 0) {
                return -1;
            }
            if (amount == 0) {
                return 0;
            }
            if (coins.length == 1 && amount < coins[0]) {

                return -1;
            }
            Integer[] newCoins = new Integer[coins.length];
            for (int i = 0; i < coins.length; i++) {
                newCoins[i] = coins[i];
            }
            Arrays.sort(newCoins, new Comparator<Integer>() {
                @Override
                public int compare(Integer t0, Integer t1) {
                    return t1 - t0;
                }
            });
            GetMinCoinCountOfValueHelper(amount, newCoins, 0, newCoins.length, 0);
            return min == Integer.MAX_VALUE ? -1 : min;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("min:" + solution.coinChange(new int[]{2}, 3));
    }
}
