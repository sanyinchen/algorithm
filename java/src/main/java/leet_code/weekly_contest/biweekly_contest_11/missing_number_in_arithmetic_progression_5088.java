package leet_code.weekly_contest.biweekly_contest_11;

import java.util.HashSet;
import java.util.Set;

public class missing_number_in_arithmetic_progression_5088 {
    class Solution {
        public int missingNumber(int[] arr) {
            Set<Integer> cache = new HashSet<>();
            int step = arr[arr.length-1] - arr[arr.length-2];
            for (int i = 1; i < arr.length; i++) {
                int temp = arr[i] - arr[i - 1];
                if (!cache.contains(temp)) {
                    cache.add(temp);
                } else {
                    step = temp;
                    break;
                }
            }
            for (int i = 1; i < arr.length; i++) {
                if ((arr[i] - arr[i - 1]) != step) {
                    return arr[i - 1] + step;
                }
            }
            return -1;
        }
    }
}
