package leet_code;

import java.util.HashSet;
import java.util.Set;

public class Find_the_duplicate_number_287 {
    class Solution {
        public int findDuplicate(int[] nums) {
            Set<Integer> cache = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (!cache.contains(nums[i])) {
                    cache.add(nums[i]);
                } else {
                    return nums[i];
                }
            }
            return nums[0];
        }
    }
}
