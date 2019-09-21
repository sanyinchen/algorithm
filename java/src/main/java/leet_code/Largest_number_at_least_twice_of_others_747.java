package leet_code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sanyinchen on 19-9-21.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-21
 */

class Largest_number_at_least_twice_of_others_747 {
    static class Solution {

        public int dominantIndex(int[] nums) {
            if (nums == null || nums.length <= 0) {
                return -1;
            }
            if (nums.length == 1) {
                return 0;
            }
            int max = -1;
            int maxIndex = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                    maxIndex = i;
                }
            }
            Arrays.sort(nums);
            if (max / 2 >= nums[nums.length - 2]) {
                return maxIndex;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().dominantIndex(new int[]{0, 0, 3, 2}));
    }
}
