package leet_code_part2;

import java.util.HashMap;
import java.util.Map;

public class Majority_element_169 {
    class Solution {
        public int majorityElement(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int item : nums) {
                if (!map.containsKey(item)) {
                    map.put(item, 1);
                } else {
                    map.replace(item, map.get(item) + 1);
                }
                if (map.get(item) > nums.length / 2) {
                    return item;
                }
            }
            return -1;
        }
    }
}
