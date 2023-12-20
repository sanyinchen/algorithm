package leet_code;

public class Find_first_and_last_position_of_element_in_sorted_array_34 {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] res = new int[]{-1, -1};
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    if (res[0] == -1) {
                        res[0] = i;
                        res[1] = i;
                        continue;
                    } else {
                        res[1] = i;
                    }
                }
            }
            return res;
        }
    }
}
