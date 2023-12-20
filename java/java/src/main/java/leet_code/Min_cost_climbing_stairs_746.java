package leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
        Map<Integer, Integer> marked = new HashMap<>();

        private int climbStairsHelper(List<Integer> costs, int n) {
            if (n == 0) {
                return costs.get(0);
            }
            if (n < 0) {
                return Integer.MAX_VALUE;
            }
            if (marked.containsKey(n)) {
                return marked.get(n);
            }
            int minCost = Math.min(climbStairsHelper(costs, n - 1), climbStairsHelper(costs, n - 2)) + costs.get(n);
            marked.put(n, minCost);
            return minCost;

        }


        public int minCostClimbingStairs(int[] cost) {
            List<Integer> costs = new ArrayList<>();
            costs.add(0);
            for (int i = 0; i < cost.length; i++) {
                costs.add(cost[i]);
            }
            costs.add(0);

            return climbStairsHelper(costs, costs.size() - 1);
        }
    }

    public static void main(String[] args) {
        // System.out.println("==>" + new Solution().minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100,
        //        1}));

        System.out.println("==>" + new Solution().minCostClimbingStairs(new int[]{10, 15, 20}));

    }
}
