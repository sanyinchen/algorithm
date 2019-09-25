package leet_code;

/**
 * Created by sanyinchen on 19-9-25.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-25
 */

class Implement_strstr_28 {
    class Solution {
        public int strStr(String haystack, String needle) {
            if (haystack == null || needle == null) {
                return -1;
            }
            if (needle.length() > haystack.length()) {
                return -1;
            }
            return haystack.indexOf(needle);
        }
    }
}
