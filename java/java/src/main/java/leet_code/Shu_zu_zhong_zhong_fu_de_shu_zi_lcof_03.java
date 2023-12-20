package leet_code;

import java.util.HashSet;
import java.util.Set;

public class Shu_zu_zhong_zhong_fu_de_shu_zi_lcof_03 {
    class Solution {
        public int findRepeatNumber(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (set.contains(nums[i])) {
                    return nums[i];
                }
                set.add(nums[i]);
            }
            return -1;
        }
    }
}
