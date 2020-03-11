package leet_code_part2;

/**
 * Created by sanyinchen on 20-3-11.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-3-11
 */

// todo fail
class Coin_change_322 {
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[][] dp = new int[coins.length][amount + 1];
            for (int i = 1; i <= amount; i++) {
                dp[0][i] = 1;
            }
            for (int i = 1; i < coins.length; i++) {
                for (int j = 1; j <= amount; j++) {
                    if (j < coins[i]) {
                        continue;
                    }
                    dp[i][j] = dp[i - 1][j - coins[i]] + 1;
                }
            }
            return dp[coins.length - 1][amount] > amount ? -1 : dp[coins.length - 1][amount];
        }
    }
}
