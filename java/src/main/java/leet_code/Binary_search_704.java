package leet_code;

public class Binary_search_704 {
    static class Solution {
        private int search(int[] nums, int target, int l, int r) {
            if (l > r) {
                return -1;
            }
            int mid = (l + r) >>> 1;
            System.out.println("mid:" + mid);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                return search(nums, target, mid + 1, r);
            } else {
                return search(nums, target, l, mid - 1);
            }
        }

        public int search(int[] nums, int target) {
            return search(nums, target, 0, nums.length - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }
}
