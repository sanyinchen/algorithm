package leet_code;

import java.util.HashMap;
import java.util.Map;

// todo FAIL
public class Coin_lcci_08_11 {
    static class Solution {
        static Map<Integer, Integer> cache = new HashMap<>();

        static {
            cache.put(1, 1);
        }

        int number = 0;

        private boolean waysToChangeHelper(int n) {
            if (n <= 1) {
                number++;
                return true;
            }
            if (cache.containsKey(n)) {
                number += cache.get(n);
                return true;
            }
            if (n % 25 == 0) {
                if (waysToChangeHelper(n - 25)) {
                    cache.put(n, number);
                }
            }
            if (n % 10 == 0) {
                if (waysToChangeHelper(n - 10)) {
                    cache.put(n, number);
                }
            }
            if (n % 5 == 0) {
                if (waysToChangeHelper(n - 5)) {
                    cache.put(n, number);
                }
            }
            waysToChangeHelper(0);
            return false;
        }

        public int waysToChange(int n) {
            waysToChangeHelper(n);
            return number;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.waysToChange(1000);
        System.out.println("res:" + res);
    }
}
