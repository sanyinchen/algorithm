package leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// todo fail
public class Three_sum_15 {
    static class Solution {
        private String getCacheKey(int... nums) {
            Arrays.sort(nums);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < nums.length; i++) {
                stringBuilder.append(nums[i]).append("_");
            }
            return stringBuilder.toString();
        }


        public List<List<Integer>> threeSum(int[] nums) {
            Map<Integer, Integer> cache = new HashMap<>();
            Set<String> cacheKey = new HashSet<>();
            Set<String> cacheKey1 = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (!cache.containsKey(nums[i])) {
                    cache.put(nums[i], 1);
                } else {
                    cache.replace(nums[i], cache.get(nums[i]) + 1);
                }
            }
            List<Pair> pairs = new ArrayList<>();
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    String key = getCacheKey(nums[i], nums[j]);
                    if (cacheKey1.contains(key)) {
                        continue;
                    }
                    cacheKey1.add(key);
                    pairs.add(new Pair(nums[i], nums[j]));
                }
            }
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < pairs.size(); i++) {
                Map<Integer, Integer> temp = new HashMap<>();
                temp.putAll(cache);
                Pair pair = pairs.get(i);
                int first = pair.first;
                int second = pair.second;
                int guess = 0 - first - second;

                temp.replace(first, temp.get(first) - 1);
                temp.replace(second, temp.get(second) - 1);
                String key = getCacheKey(first, second, guess);
                if (cacheKey.contains(key)) {
                    continue;
                }
                cacheKey.add(key);
                if (temp.containsKey(guess) && temp.get(guess) >= 1) {
                    List<Integer> child = new ArrayList<>();
                    child.add(first);
                    child.add(second);
                    child.add(guess);
                    res.add(child);
                }

            }
            return res;
        }

        private class Pair {
            int first;
            int second;

            public Pair(int first, int second) {
                this.first = first;
                this.second = second;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = solution.threeSum(test);
        res.forEach(item -> {

            item.forEach(integer -> {
                System.out.print(integer + " ");
            });
            System.out.println();
        });
    }
}
