package leet_code_part2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Fei_bo_na_qi_shu_lie_lcof_10 {
    class Solution {
        Map<Integer, Integer> cache = new HashMap<>();

        public int fib(int n) {
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return 1;
            }
            if (cache.containsKey(n)) {
                return cache.get(n);
            }

            int res = (fib(n - 1) + fib(n - 2)) % 1000000007;
            cache.put(n, res);
            return res;
        }
    }
}
