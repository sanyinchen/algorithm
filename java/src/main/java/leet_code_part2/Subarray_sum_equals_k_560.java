package leet_code_part2;

import java.util.Arrays;

/**
 * Created by sanyinchen on 20-5-15.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-5-15
 */

// todo fail
public class Subarray_sum_equals_k_560 {

    public static class Solution {

        private long getSum(int s, int e, int[] nums) {
            long sum = 0;
//            if (s >= e || s >= nums.length) {
//                return Long.MAX_VALUE;
//            }
            for (int i = s; i <= e && i < nums.length; i++) {
                sum += nums[i];
            }
            return sum;
        }

        public int subarraySum(int[] nums, int k) {
            long tempSum = 0;

            if (nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return k == nums[0] ? 1 : 0;
            }
            Arrays.sort(nums);
            int number = 0;
//            tempSum = nums[0];
//
            int i = 0, j = 0;
            while (i < nums.length || j < nums.length) {

                long sum = getSum(i, j, nums);

                if (sum < k) {
                    if (j < nums.length) {
                        j++;
                    } else if (i < nums.length) {
                        i++;
                    } else {
                        break;
                    }
                }
                if (sum > k) {
                    if (i == j) {
                        i++;
                        j++;
                    } else if (i < nums.length) {
                        i++;
                    } else {
                        break;
                    }

                }
                if (sum == k) {

                    if (j < nums.length) {
                        j++;
                        if (i < nums.length) {
                            number++;
                        }
                        System.out.println("i:" + i + " j:" + j);
                    } else if (i < nums.length) {
                        i++;

                        number++;

                        System.out.println("i:" + i + " j:" + j);
                    } else {
                        break;
                    }

                }
            }
            return number;
        }
    }


    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.subarraySum(new int[]{1, 1, 1}, 2));

    }
}
