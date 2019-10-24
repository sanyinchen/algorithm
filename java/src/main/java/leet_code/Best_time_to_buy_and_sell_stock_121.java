package leet_code;

/**
 * Created by sanyinchen on 19-10-24.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-24
 */

class Best_time_to_buy_and_sell_stock_121 {
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }
            int max = 0;
            int min = prices[0];
            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < min) {
                    min = prices[i];
                }
                if (prices[i] - min > max) {
                    max = prices[i] - min;
                }
            }
            return max;
        }
    }
}
