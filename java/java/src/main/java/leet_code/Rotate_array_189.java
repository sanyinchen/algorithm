package leet_code;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanyinchen on 19-9-26.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-26
 */

class Rotate_array_189 {
    static class Solution {
        public void rotate(int[] nums, int k) {
            if (nums == null || nums.length == 0 || k == 0) {
                return;
            }
            List<Integer> numsList = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                numsList.add(nums[i]);
            }

            int start = (k) % nums.length;
            List<Integer> res = new ArrayList<>();
            res.addAll(numsList.subList(numsList.size() - start, numsList.size()));
            res.addAll(numsList.subList(0, numsList.size() - start));
            for (int i = 0; i < nums.length; i++) {
                nums[i] = res.get(i);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        new Solution().rotate(nums, 3);
        // int[] nums = new int[]{1, 2};
        // new Solution().rotate(nums, 1);
        System.out.println("===========>");

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
