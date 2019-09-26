package leet_code;

/**
 * Created by sanyinchen on 19-9-26.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-26
 */

// todo fail
class Rotate_array_189 {
    static class Solution {
        public void rotate(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return;
            }
            int start = k % nums.length;
            System.out.println("start:" + start);
            int temp = (start + 1) % nums.length;
            for (int i = start; i != start - 1; i = (i + 1) % nums.length) {
                int a = nums[i];

                System.out.println("i:" + i + " a:" + a + " j:" + (i + start) % nums.length);
                nums[i] = nums[(i + start) % nums.length];
                nums[(i + start) % nums.length] = a;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        new Solution().rotate(nums, 3);

        System.out.println("===========>");

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
