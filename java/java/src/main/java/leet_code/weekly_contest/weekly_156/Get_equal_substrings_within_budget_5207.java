package leet_code.weekly_contest.weekly_156;

// todo fail
public class Get_equal_substrings_within_budget_5207 {
    static class Solution {
        private int getCost(int[][] costs, int i, int j) {
            if (i < 0 || j < 0 || i >= costs.length || j >= costs[i].length) {
                return Integer.MAX_VALUE;
            }
            return costs[i][j];
        }

        public int equalSubstring(String s, String t, int maxCost) {
            if (s == null || t == null || s.length() == 0 || t.length() == 0) {
                return 0;
            }
            char[] s1 = s.toCharArray();
            char[] s2 = t.toCharArray();
            int length = s1.length;
            //int cost = 0;
            int[][] costs = new int[length][length];
            //  costs[0][0]=Math.abs(s2[0] - s1[0]);
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    int tempCost = Math.abs(s2[i] - s1[j]);
                    // cost += tempCost;

                    int cost = 0;
                    int left = Math.abs(getCost(costs, i - 1, j));
                    int top = Math.abs(getCost(costs, i, j - 1));
                    int pre = Math.abs(getCost(costs, i - 1, j - 1));
                    int min = Math.min(left, top);
                    if (min == Integer.MAX_VALUE && pre == Integer.MAX_VALUE) {
                        cost = Integer.MAX_VALUE;
                    } else {
                        cost = Math.abs(Math.min(min, pre) + tempCost);
                    }
                    // System.out.println("cost:"+cost);
                    if (cost <= maxCost) {
                        costs[i][j] = costs[i - 1][j - 1] + 1;
                    } else {
                        costs[i][j] = Math.max(costs[i - 1][j], costs[i][j - 1]);
//                        int s1Index = i - 1;
//                        int s2Index = j - 1;
//
//                        costs[i][j] = Math.min(costs[s1Index < 0 ? 0 : s1Index][j], costs[i][s2Index < 0 ? 0 :
//                                s2Index]);
                    }
                }

            }
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    System.out.print(costs[i][j] + " ");
                }
                System.out.println();
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println("==>" + new Solution().equalSubstring("abcd", "bcdf", 3));
    }
}
