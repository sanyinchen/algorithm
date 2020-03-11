package leet_code_part2;

/**
 * Created by sanyinchen on 20-3-11.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-3-11
 */

class Partition_array_into_three_parts_with_equal_sum_1013 {
    static class Solution {
        private int[] getRange(int start, int[] array, int target) {
            if (start >= array.length) {
                return new int[0];
            }
            int sum = 0;
            int end;
            for (int i = start; i < array.length; i++) {
                sum += array[i];
                end = i;
                if (sum == target) {
                    return new int[]{start, end};
                }
            }
            return new int[0];
        }

        public boolean canThreePartsEqualSum(int[] array) {
            int sum = 0;
            for (int i = 0; i < array.length; i++) {
                sum += array[i];
            }
            if (sum % 3 != 0) {
                return false;
            }
            int target = sum / 3;
            int[] first = getRange(0, array, target);
            if (first.length != 2) {
                return false;
            }
            int[] second = getRange(first[1] + 1, array, target);
            if (second.length != 2) {
                return false;
            }
            int[] third = getRange(second[1] + 1, array, target);
            if (third.length != 2) {
                return false;
            }
            // final check
            int temp = 0;
            for (int i = second[1] + 1; i < array.length; i++) {
                temp += array[i];
            }
            return temp == target;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canThreePartsEqualSum(new int[]{12, -4, 16, -5, 9, -3, 3, 8, 0}));
    }
}
