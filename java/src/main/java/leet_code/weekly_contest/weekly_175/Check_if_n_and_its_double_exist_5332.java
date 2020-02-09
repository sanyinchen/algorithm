package leet_code.weekly_contest.weekly_175;

import java.util.HashMap;
import java.util.Map;

public class Check_if_n_and_its_double_exist_5332 {
    static class Solution {
        public boolean checkIfExist(int[] arr) {
            Map<Long, Integer> cache = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                long key = (long) arr[i];
                if (!cache.containsKey(key)) {
                    cache.put(key, 1);
                } else {
                    cache.replace(key, cache.get(key) + 1);
                }
            }
            for (int i = 0; i < arr.length; i++) {
                long guess = arr[i] * 2;

                if (cache.containsKey(guess)) {
                    int number = cache.get(guess);
                    if (arr[i] == guess) {
                        number--;
                    }
                    if (number > 0) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkIfExist(new int[]{10, 2, 5, 3}));
    }
}
