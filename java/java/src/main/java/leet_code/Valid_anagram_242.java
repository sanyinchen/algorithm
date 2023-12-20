package leet_code;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sanyinchen on 19-9-21.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-21
 */

class Valid_anagram_242 {
    static class Solution {
        public boolean isAnagram(String s, String t) {
            if (s == null && t == null) {
                return true;
            }
            if (s == null || t == null) {
                return false;
            }
            if (s.length() != t.length()) {
                return false;
            }

            Map<Character, Integer> cache = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                if (!cache.containsKey(s.charAt(i))) {
                    cache.put(s.charAt(i), 1);
                } else {
                    cache.replace(s.charAt(i), cache.get(s.charAt(i)) + 1);
                }
            }
            for (int i = 0; i < t.length(); i++) {
                if (!cache.containsKey(t.charAt(i))) {
                    return false;
                }
                int newNumber = cache.get(t.charAt(i)) - 1;
                if (newNumber <= 0) {
                    cache.remove(t.charAt(i));
                } else {
                    cache.replace(t.charAt(i), newNumber);
                }
            }
            return cache.size() == 0;
        }
    }

    public static void main(String[] args) {
        System.out.println("==>" + new Solution().isAnagram("anagram", "nagaram"));
    }

}
