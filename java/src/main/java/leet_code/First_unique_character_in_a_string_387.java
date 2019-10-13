package leet_code;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sanyinchen on 19-10-13.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-13
 */

class First_unique_character_in_a_string_387 {
    class Solution {
        public int firstUniqChar(String s) {
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                if (!map.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i), 1);
                } else {
                    int number = map.get(s.charAt(i));
                    map.replace(s.charAt(i), ++number);
                }
            }
            for (int i = 0; i < s.length(); i++) {
                if (map.get(s.charAt(i)) == 1) {
                    return i;
                }
            }
            return -1;
        }
    }
}
