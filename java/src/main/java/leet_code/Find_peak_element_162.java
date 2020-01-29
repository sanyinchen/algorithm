package leet_code;

public class Find_peak_element_162 {
    class Solution {
        public int findPeakElement(int[] nums) {
            int max = nums[0];
            int maxIndex = 0;
            for (int i = 1; i < nums.length; i++) {
                if (max < nums[i]) {
                    max = nums[i];
                    maxIndex = i;
                }
            }
            return maxIndex;
        }
    }
}
