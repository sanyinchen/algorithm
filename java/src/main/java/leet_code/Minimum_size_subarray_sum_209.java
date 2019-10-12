package leet_code;

/**
 * Created by sanyinchen on 19-10-11.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-11
 */

class Minimum_size_subarray_sum_209 {
    static class Solution {
        public int minSubArrayLen(int s, int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int min = Integer.MAX_VALUE;
            int sum = nums[0];
            for (int i = 0, j = 0; i < nums.length; ) {
                if (sum >= s) {
                    min = Math.min(min, j - i + 1);
                    sum -= nums[i];
                    i++;
                } else {
                    j++;
                    if (j < nums.length) {
                        sum += nums[j];
                    } else {
                        sum -= nums[i];
                        i++;
                    }
                }
            }
            return min == Integer.MAX_VALUE ? 0 : min;
        }
    }

    public static void main(String[] args) {
        int[] inputs = new int[]{2, 3, 1, 2, 4, 3};
        System.out.println("=====>" + new Solution().minSubArrayLen(7, inputs));
    }
}
