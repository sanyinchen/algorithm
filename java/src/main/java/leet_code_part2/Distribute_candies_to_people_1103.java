package leet_code_part2;

/**
 * Created by sanyinchen on 20-3-5.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-3-5
 */

class Distribute_candies_to_people_1103 {
    class Solution {
        public int[] distributeCandies(int candies, int num_people) {
            int[] nums = new int[num_people];
            int i = 0;
            while (candies >= 0) {
                int need = i + 1;
                if (candies <= need) {
                    nums[i % num_people] += candies;
                    break;
                } else {
                    nums[i % num_people] += need;
                }
                candies -= need;
                i++;
            }
            return nums;
        }
    }
}
