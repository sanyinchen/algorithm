package leet_code;

/**
 * Created by sanyinchen on 20-1-15.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-1-15
 */

class Remove_duplicates_from_sorted_array_ii_80 {
    static class Solution {

        private void move2Last(int[] nums, int i) {
            if (i >= nums.length) {
                return;
            }
            int temp;
            for (int index = i; index < nums.length - 1; index++) {
                temp = nums[index];
                nums[index] = nums[index + 1];
                nums[index + 1] = temp;
            }
        }

        public int removeDuplicates(int[] nums) {
            int times = 1;
            int len = nums.length;
            for (int i = 1; i < len; i++) {
                if (nums[i] == nums[i - 1]) {
                    times++;
                } else {
                    times = 1;
                }
                if (times > 2) {
                    len--;
                    i--;
                    times--;
                    move2Last(nums, i);

                }
            }
            return len;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 1, 1};
        int len = solution.removeDuplicates(nums);
        System.out.println("len:" + len);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
