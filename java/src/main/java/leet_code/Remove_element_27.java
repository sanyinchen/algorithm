package leet_code;

import java.util.Arrays;

public class Remove_element_27 {
    public static class Solution {
        private void swap(int[] nums, int a, int b) {
            int c = nums[a];
            nums[a] = nums[b];
            nums[b] = c;
        }

        public int removeElement(int[] nums, int val) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                if (nums[0] == val) {
                    return 0;
                }
                return 1;
            }
            if (nums.length <= 2) {

                if (nums[0] == val && nums[1] != val) {
                    swap(nums, 0, 1);
                    return 1;
                }
                if (nums[0] == val && nums[1] == val) {
                    return 0;
                }
                if (nums[0] != val && nums[1] != val) {
                    return 2;
                }

                return 1;
            }
            for (int i = 0, j = nums.length - 1; i <= j; ) {
                System.out.println("i:" + i + " j:" + j + " nmus[i]" + nums[i] + " " + nums[j]);
                if (nums[i] != val) {
                    i++;
                    continue;
                }
                if (nums[j] == val) {
                    j--;
                    continue;
                }
                if (nums[i] == val && nums[j] != val) {
                    swap(nums, i, j);
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == val) {
                    return i;
                }
            }
            return nums.length;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 4, 0, 1, 0, 2};
        int len = new Solution().removeElement(nums, 0);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]);
        }
        System.out.println();
    }
}
