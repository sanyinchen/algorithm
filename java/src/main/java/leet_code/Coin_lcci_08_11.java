package leet_code;

import java.util.HashMap;
import java.util.Map;

public class Coin_lcci_08_11 {
    static class Solution {

        private int getValidValue(int value) {
            return value % 1000000007;
        }


        public int waysToChange(int n) {
            int[] coins = new int[]{1, 5, 10, 25};
            int[][] dp = new int[coins.length][n + 1];
            for (int i = 1; i < coins.length; i++) {
                dp[i][0] = 1;
            }
            for (int i = 1; i <= n; i++) {
                dp[0][i] = 1;
            }
            for (int i = 1; i < coins.length; i++) {
                for (int j = 1; j <= n; j++) {
                    if (j < coins[i]) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = getValidValue(dp[i - 1][j] + dp[i][j - coins[i]]);
                    }
                }
            }

            return dp[coins.length - 1][n];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.waysToChange(20);
        System.out.println("res:" + res);
    }
}
