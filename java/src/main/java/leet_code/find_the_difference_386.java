package leet_code;

/**
 * Created by sanyinchen on 19-10-25.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-25
 */

class find_the_difference_386 {
    class Solution {
        public char findTheDifference(String s, String t) {
            int len = 'z' + 1;
            int[] a = new int[len];
            int[] b = new int[len];
            for (int i = 0; i < s.length(); i++) {
                a[s.charAt(i)]++;
            }
            for (int i = 0; i < t.length(); i++) {
                b[t.charAt(i)]++;
            }
            for (int i = 'a'; i < len; i++) {
                if (a[i] != b[i]) {
                    return (char) i;
                }
            }
            return '0';
        }
    }
}
