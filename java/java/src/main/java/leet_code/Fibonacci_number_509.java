package leet_code;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sanyinchen on 19-9-18.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-18
 */

class Fibonacci_number_509 {
    public static class Solution {
        private Map<Integer, Integer> map = new HashMap<>();

        public int fib(int N) {
            if (N == 0) {
                return 0;
            }
            if (N == 1) {
                return 1;
            }
            if (map.containsKey(N)) {
                return map.get(N);
            }
            int sum = fib(N - 1) + fib(N - 2);
            map.put(N, sum);
            return sum;
        }
    }
}
