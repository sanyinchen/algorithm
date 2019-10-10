package leet_code;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sanyinchen on 19-10-9.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-9
 */

class House_robber_198 {
    class Solution {
        Map<Integer, Integer> marked = new HashMap<>();

        private int robHelper(int[] nums, int n) {
            if (n == 0) {
                return nums[0];
            }
            if (n < 0) {
                return 0;
            }
            if (marked.containsKey(n)) {
                return marked.get(n);
            }
            int max = Math.max(robHelper(nums, n - 2) + nums[n], robHelper(nums, n - 1));
            marked.put(n, max);
            return max;
        }

        public int rob(int[] nums) {
            return robHelper(nums, nums.length - 1);
        }
    }
}
