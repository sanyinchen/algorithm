package leet_code;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sanyinchen on 19-9-26.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-26
 */

class Max_consecutive_ones_485 {
    class Solution {

        private int getValue(Map<String, Integer> map, int i, int j) {
            if (map.containsKey(i + "_" + j)) {
                return map.get(i + "_" + j);
            }
            return 0;
        }

        public int findMaxConsecutiveOnes(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            Map<String, Integer> mark = new HashMap<>();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 1) {
                    int temp = getValue(mark, i - 1, i - 1) + 1;
                    mark.put(i + "_" + i, temp);
                    if (max < temp) {
                        max = temp;
                    }
                }
            }
            return max == Integer.MIN_VALUE ? 0 : max;
        }
    }
}
