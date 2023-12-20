package leet_code_part2;

import java.util.HashMap;
import java.util.Map;

public class Qing_wa_tiao_tai_jie_wen_ti_lcof_10_2 {
    class Solution {
        Map<Integer, Integer> cache = new HashMap<>();


        public int numWays(int n) {
            if (n == 0) {
                return 1;
            }
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }
            if (cache.containsKey(n)) {
                return cache.get(n);
            }
            int number = (numWays(n - 1) + numWays(n - 2))%1000000007;
            cache.put(n, number);
            return number;
        }
    }
}
