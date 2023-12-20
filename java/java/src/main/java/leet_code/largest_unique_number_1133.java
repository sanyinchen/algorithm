package leet_code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sanyinchen on 19-10-25.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-25
 */

class largest_unique_number_1133 {
    class Solution {
        public int largestUniqueNumber(int[] a) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < a.length; i++) {
                if (!map.containsKey(a[i])) {
                    map.put(a[i], 1);
                } else {
                    int numer = map.get(a[i]);
                    map.put(a[i], ++numer);
                }
            }
            Arrays.sort(a);
            for (int i = a.length - 1; i >= 0; i--) {
                if (map.get(a[i]) == 1) {
                    return a[i];
                }
            }
            return -1;
        }
    }
}
