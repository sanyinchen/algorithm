package leet_code;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanyinchen on 19-10-13.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-13
 */

class Permutations_46 {

    static class Solution {
        private List<List<Integer>> res = new ArrayList<>();


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
                for (int v : nums) {
                    temp.add(v);
                    System.out.print(v + " ");
                }
                System.out.println();
                res.add(temp);
                return;
            }

            for (int i = start; i <end; i++) {
                swap(nums, i, start);
                permuteHelper(nums, start + 1, end);
                swap(nums, i, start);
            }

        }

        public List<List<Integer>> permute(int[] nums) {
            res.clear();
            permuteHelper(nums, 0, nums.length);
            return res;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 2, 3};
        solution.permute(nums);
    }
}
