package leet_code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sanyinchen on 19-10-13.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-13
 */

class Permutations_ii_47 {
    static class Solution {
        private List<List<Integer>> res = new ArrayList<>();
        private Set<String> cache = new HashSet<>();

        private void swap(int[] nums, int i, int j) {
            if (i < 0 || j < 0 || i >= nums.length || j >= nums.length) {
                return;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        private void permuteHelper(int[] nums, int start, int end) {
            if (start == end) {
                List<Integer> temp = new ArrayList<>();
                StringBuilder str = new StringBuilder();
                for (int v : nums) {
                    temp.add(v);
                    str.append(v);
                }
                String check = str.toString();
                if (!cache.contains(check)) {
                    cache.add(check);
                    res.add(temp);
                }
                return;
            }

            for (int i = start; i < end; i++) {
                swap(nums, i, start);
                permuteHelper(nums, start + 1, end);
                swap(nums, i, start);
            }

        }

        public List<List<Integer>> permuteUnique(int[] nums) {
            res.clear();
            cache.clear();
            permuteHelper(nums, 0, nums.length);
            return res;
        }

    }

}
