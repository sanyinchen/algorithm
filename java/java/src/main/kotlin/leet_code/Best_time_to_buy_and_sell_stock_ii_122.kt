package leet_code

/**
 * Created by sanyinchen on 19-10-12.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-12
 */
class Best_time_to_buy_and_sell_stock_ii_122 {
    fun maxProfit(prices: IntArray): Int {
        var sum = 0;
        for (index in IntRange(0, prices.size - 2)) {
            if (prices[index + 1] - prices[index] > 0) {
                sum += prices[index + 1] - prices[index]
            }
        }
        return sum;
    }
}