package leet_code_part2;

/**
 * Created by sanyinchen on 20-6-5.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-6-5
 */

class String_to_url_lcci_01_03 {
    class Solution {
        public String replaceSpaces(String S, int length) {
            return S.substring(0, length).replaceAll(" ", "%20");
        }
    }
}
