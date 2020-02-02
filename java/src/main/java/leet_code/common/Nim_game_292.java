package leet_code.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Nim_game_292 {
    static class Solution {
        Map<Integer, Boolean> cache = new HashMap<>();

        private boolean canWinNimHelper(int n, int times) {
            if (cache.containsKey(n)) {
                return cache.get(n);
            }
            if (n <= 0) {
                // System.out.println("times:"+times);
                return times / 2 == 0;
            }
            if (n <= 3 && n >= 1) {
                return times / 2 == 1;
            }
            boolean res =
                    canWinNimHelper(n - 1, times + 1) || canWinNimHelper(n - 2, times + 1) || canWinNimHelper(n - 3,
                            times + 1);
            cache.put(n, res);
            return res;
        }

        public boolean canWinNim(int n) {
            if (n >= 1 && n <= 3) {
                return true;
            }
            return canWinNimHelper(n, 0);
        }
    }
}
