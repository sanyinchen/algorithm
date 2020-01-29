package leet_code;

public class Search_in_rotated_sorted_array_33 {
    static class Solution {

        private int binarySearch(int[] nums, int target, int l, int r) {
            if (l > r) {
                return -1;
            }
            int mid = (l + r) >>> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[l] == target) {
                return l;
            }
            if (nums[r] == target) {
                return r;
            }
            if (nums[l] <= nums[mid]) {
                if (nums[l] < target && target < nums[mid]) {
                    return binarySearch(nums, target, l, mid - 1);
                } else {
                    return binarySearch(nums, target, mid + 1, r);
                }

            } else {
                if (nums[mid] < target && target < nums[r]) {
                    return binarySearch(nums, target, mid + 1, r);
                } else {
                    return binarySearch(nums, target, l, mid - 1);
                }
            }
        }

        public int search(int[] nums, int target) {

            return binarySearch(nums, target, 0, nums.length - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int mid = solution.search(nums, 0);
        System.out.println("mid:" + mid);
    }
}
