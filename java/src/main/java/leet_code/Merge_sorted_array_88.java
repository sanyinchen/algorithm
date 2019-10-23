package leet_code;

/**
 * Created by sanyinchen on 19-10-23.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-23
 */

class Merge_sorted_array_88 {
    static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int[] temp = nums1.clone();
            int i = 0;
            int j = 0;
            int k = 0;
            while (k <(m + n)) {
                do {
                    if (i >= m && j < n) {
                        nums1[k++] = nums2[j++];
                        break;
                    }
                    if (j >= n && i < m) {
                        nums1[k++] = temp[i++];
                        break;
                    }
                    if (temp[i] <= nums2[j]) {
                        nums1[k++] = temp[i++];
                        break;
                    }
                    nums1[k++] = nums2[j++];
                } while (false);
            }
        }
    }

    public static void main(String[] args) {
        int[] input1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] input2 = new int[]{2, 5, 6};
        new Solution().merge(input1, 3, input2, 3);
        for (int i = 0; i < 6; i++) {
            System.out.print(input1[i] + " ");
        }
    }
}
