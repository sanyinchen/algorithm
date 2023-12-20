package leet_code;

import java.util.Arrays;

public class missing_number_268 {
    class Solution {
        public int missingNumber(int[] nums) {
            Arrays.sort(nums);
            for (int i = 0; i <= nums.length; i++) {
                if (nums[i % nums.length] != i) {
                    return i;
                }
            }
            return -1;
        }
    }
}
