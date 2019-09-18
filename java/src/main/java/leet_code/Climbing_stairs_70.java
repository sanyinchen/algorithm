package leet_code;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sanyinchen on 19-9-18.
 * <p>
 * from https://leetcode-cn.com/problems/climbing-stairs/
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-18
 */

class Climbing_stairs_70 {
    static class Solution {
        private Map<Integer, Integer> cache = new HashMap<>();

        private int climbStairsHelper(int n) {
            if (cache.containsKey(n)) {
                return cache.get(n);
            }
            if (n == 0) {
                return 1;
            }
            if (n < 0) {
                return 0;
            }
            int sum = climbStairsHelper(n - 1) + climbStairsHelper(n - 2);
            cache.put(n, sum);
            return sum;
        }

        public int climbStairs(int n) {

            return climbStairsHelper(n);
        }
    }

    public static void main(String[] args) {
        System.out.println("==>" + new Solution().climbStairs(2));
    }
}
