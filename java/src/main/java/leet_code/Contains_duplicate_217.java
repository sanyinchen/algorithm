package leet_code;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sanyinchen on 19-9-21.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-21
 */

class Contains_duplicate_217 {
    public static class Solution {
        public boolean containsDuplicate(int[] nums) {
            if (nums == null || nums.length <= 0) {
                return false;
            }
            Set<Integer> cache = new HashSet<>();
            for (int item : nums) {
                if (cache.contains(item)) {
                    return true;
                }
                cache.add(item);
            }
            return false;
        }
    }
}
