package leet_code;

/**
 * Created by sanyinchen on 19-9-21.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-21
 */

class find_pivot_index_724 {
    static class Solution {
        private int pivotIndexHelper(int[] nums, int i, int lSum, int rSum) {
            if (lSum == rSum) {
                return i;
            }
            if (i + 1 == nums.length) {
                return -1;
            }
            return pivotIndexHelper(nums, i + 1, lSum + nums[i], rSum - nums[i + 1]);

        }

        public int pivotIndex(int[] nums) {
            if (nums == null) {
                return -1;
            }

            if (nums.length <= 2) {
                return -1;
            }
            int mid = 0;
            int lsum = 0;
            int rsum = 0;
            for (int i = mid + 1; i < nums.length; i++) {
                rsum += nums[i];
            }
            return pivotIndexHelper(nums, mid, lsum, rsum);
        }
    }

    public static void main(String[] args) {
        System.out.println("===>" + new Solution().pivotIndex(new int[]{-1, -1, -1, 0, 1, 1}));
    }
}
