package leet_code;

/**
 * Created by sanyinchen on 19-10-24.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-24
 */

class Maximum_subarray_53 {
    class Solution {
        public int maxSubArray(int[] nums) {
            int max = nums[0];
            int sum = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (sum + nums[i] > nums[i]) {
                    sum += nums[i];
                } else {
                    sum = nums[i];
                }
                max = Math.max(sum, max);
            }
            return max;
        }
    }
}
