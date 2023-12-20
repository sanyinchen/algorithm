package leet_code_part2.contest.weekly_contest_178;

public class how_many_numbers_are_smaller_than_the_current_number_5344 {

    class Solution {
        public int[] smallerNumbersThanCurrent(int[] nums) {
            int[] res = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                int number = 0;
                for (int j = 0; j < nums.length; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (nums[j] < nums[i]) {
                        number++;
                    }
                }
                res[i] = number;
            }
            return res;
        }
    }
}
