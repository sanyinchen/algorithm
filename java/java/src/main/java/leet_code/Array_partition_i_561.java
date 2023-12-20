package leet_code;

import java.util.Arrays;

/**
 * Created by sanyinchen on 19-9-25.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-25
 */

class Array_partition_i_561 {
    class Solution {
        public int arrayPairSum(int[] nums) {
            if (nums == null || nums.length % 2 != 0) {
                return -1;
            }
            if (nums.length == 2) {
                return Math.min(nums[0], nums[1]);
            }
            Arrays.sort(nums);
            int sum = 0;
            int mid = nums.length / 2;
            if (mid % 2 != 0) {
                mid--;
                sum += Math.min(nums[mid], nums[mid + 1]);
            }
            for (int i = 0, j = nums.length - 1; i < j && i + 1 < mid; i += 2, j -= 2) {
                sum += Math.min(nums[i], nums[i + 1]);
                sum += Math.min(nums[j], nums[j - 1]);
            }

            return sum;
        }
    }
}
