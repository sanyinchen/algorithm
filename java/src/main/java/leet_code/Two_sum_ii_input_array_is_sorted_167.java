package leet_code;

import java.util.HashMap;
import java.util.Map;

public class Two_sum_ii_input_array_is_sorted_167 {
    static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            Map<Integer, Integer> cache = new HashMap<>();
            for (int i = 0; i < numbers.length; i++) {
                if (cache.containsKey(target - numbers[i])) {
                    return new int[]{cache.get(target - numbers[i])+1, i+1};
                }
                cache.put(numbers[i], i);
            }
            return null;
        }

    }
}
