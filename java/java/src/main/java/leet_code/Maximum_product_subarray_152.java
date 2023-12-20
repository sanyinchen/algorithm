package leet_code;

/**
 * Created by sanyinchen on 19-10-25.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-25
 */

class Maximum_product_subarray_152 {
    class Solution {
        public int maxProduct(int[] nums) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int sum = nums[0];
            int sum2 = nums[0];
            int max = sum;
            for (int i = 1; i < nums.length; i++) {
                if (sum * nums[i] >= nums[i]) {
                    sum *= nums[i];
                } else {
                    sum = nums[i];
                }
                if (sum2 * nums[i] <= nums[i]) {
                    sum2 *= nums[i];
                } else {
                    sum2 = nums[i];
                }
                max = Math.max(sum, max);
                max = Math.max(sum2, max);
            }
            return max;
        }
    }
}
