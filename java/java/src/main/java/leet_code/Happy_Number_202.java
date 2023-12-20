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

class Happy_Number_202 {

    public class Solution {
        Set<Integer> cache = new HashSet<>();

        private boolean isHappyHelper(int n) {
            if (cache.contains(n)) {
                return false;
            } else {
                cache.add(n);
            }
            if (n == 1) {
                return true;
            }
            if (n == 0) {
                return false;
            }

            int sum = (n % 10) * (n % 10);
            while ((n = (n / 10)) != 0) {
                sum += (n % 10) * (n % 10);
            }

            return isHappyHelper(sum);
        }

        public boolean isHappy(int n) {
            cache.clear();
            return isHappyHelper(n);
        }
    }

}
