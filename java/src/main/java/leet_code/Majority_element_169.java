package leet_code;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sanyinchen on 19-10-25.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-25
 */

class Majority_element_169 {
    class Solution {
        public int majorityElement(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (!map.containsKey(nums[i])) {
                    map.put(nums[i], 1);
                } else {
                    int number = map.get(nums[i]);
                    map.replace(nums[i], ++number);
                }
            }
            for (Map.Entry<Integer, Integer> item : map.entrySet()) {
                if (item.getValue() > nums.length / 2) {
                    return item.getKey();
                }
            }
            return -1;
        }
    }
}
