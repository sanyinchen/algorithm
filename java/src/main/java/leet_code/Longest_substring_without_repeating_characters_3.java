package leet_code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by sanyinchen on 19-9-20.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-20
 */

class Longest_substring_without_repeating_characters_3 {
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int[] dp = new int[s.length()];
            char[] content = s.toCharArray();
            dp[0] = 1;
            int max = dp[0];
            Map<Character, Integer> cache = new HashMap<>();
            cache.put(content[0], 0);
            for (int i = 1; i < content.length; i++) {
                if (!cache.containsKey(content[i])) {
                    dp[i] = dp[i - 1] + 1;
                    cache.put(content[i], i);
                    max = max < dp[i] ? dp[i] : max;
                } else {
                    i = cache.get(content[i]) + 1;
                    if (i >= content.length) {
                        return max;
                    }
                    cache.clear();
                    cache.put(content[i], i);
                    dp[i] = 1;
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("dvdf"));
    }
}
