package leet_code_part2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by sanyinchen on 20-6-5.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-6-5
 */

class Most_common_word_819 {
    static class Solution {
        private String getWord(String str) {
            if (str == null) {
                return "";
            }
            str = str.toLowerCase().trim();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                    stringBuilder.append(str.charAt(i));
                }
            }
            str = stringBuilder.toString();

            if (str.length() == 0) {
                return "";
            }
            return str;

        }

        public String mostCommonWord(String paragraph, String[] banned) {
            String[] words = paragraph.split(" ");
            List<Pair> list = new ArrayList<>();
            Set<String> bannedSet = new HashSet<>();
            HashMap<String, Integer> cache = new HashMap<>();
            for (int i = 0; i < banned.length; i++) {
                bannedSet.add(banned[i].trim().toLowerCase());
            }
            for (int i = 0; i < words.length; i++) {
                String[] tempWords = words[i].split(",");
                for (int j = 0; j < tempWords.length; j++) {
                    String item = getWord(tempWords[j]);
                    if (item.length() > 0 && !bannedSet.contains(item)) {
                        if (!cache.containsKey(item)) {
                            cache.put(item, 1);
                        } else {
                            cache.replace(item, cache.get(item) + 1);
                        }
                    }
                }
            }
            for (Map.Entry<String, Integer> entry : cache.entrySet()) {
                Pair pair = new Pair();
                pair.word = entry.getKey();
                pair.num = entry.getValue();
                list.add(pair);
            }
            list.sort(new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    return o2.num - o1.num;
                }
            });
            return list.get(0).word;
        }

        public class Pair {
            String word;
            int num;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String test = "a, a, a, a, b,b,b,c, c";
        System.out.println(solution.mostCommonWord(test, new String[]{"a"}));

    }
}

