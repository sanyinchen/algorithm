package leet_code;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Created by sanyinchen on 19-9-18.
 * <p>
 * from https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-18
 */

class Min_cost_climbing_stairs_746 {
    static class Solution {
        private Map<Integer, Integer> cache = new HashMap<>();
        private int min;

        private int climbStairsHelper(int[] cost, int n, Stack<Integer> res) {

            if (n == 0) {
                Stack<Integer> copied = (Stack<Integer>) res.clone();
                int sum = 0;
                while (copied.size() > 0) {
                    int item = copied.peek();
                    System.out.print(item + " ");
                    sum += cost[item - 1];
                    copied.pop();
                }
                if (min > sum) {
                    min = sum;
                }
                System.out.println();
                return 1;
            }
            if (n < 0) {
                return 0;
            }
            res.push(n);
//            if (cache.containsKey(n)) {
//                return cache.get(n);
//            }
            int sum = climbStairsHelper(cost, n - 1, res) + climbStairsHelper(cost, n - 2, res);
            res.pop();
            cache.put(n, sum);
            return sum;
        }


        public int minCostClimbingStairs(int[] cost) {
            min = Integer.MAX_VALUE;
            climbStairsHelper(cost, cost.length, new Stack<>());
            return min;
        }
    }

    public static void main(String[] args) {
        // System.out.println("==>" + new Solution().minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100,
        //        1}));

        System.out.println("==>" + new Solution().minCostClimbingStairs(new int[]{10, 15, 20}));

    }
}
