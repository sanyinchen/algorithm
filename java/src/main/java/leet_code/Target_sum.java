package leet_code;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by sanyinchen on 20-1-14.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-1-14
 */

class Target_sum {
    static class Solution {
        int number = 0;

        private void groupScan(int i, int[] nums, int res, int sum) {
            if (i >= nums.length) {
                if (sum == res) {
                    number++;
                }
                return;
            }

            for (int j = 0; j < 2; j++) {
                int gusess = j % 2 == 0 ? nums[i] : -nums[i];
                groupScan(i + 1, nums, res + gusess, sum);

            }
        }

        public int findTargetSumWays(int[] nums, int S) {

            groupScan(0, nums, 0, S);
            return number;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
