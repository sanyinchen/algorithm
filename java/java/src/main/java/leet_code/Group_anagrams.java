package leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by sanyinchen on 19-12-20.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-12-20
 */

class Group_anagrams {
    class Solution {

        private String getUnicodeHash(char[] chars) {
            Arrays.sort(chars);
            StringBuilder stringBuilder = new StringBuilder();
            for (char temp : chars) {
                stringBuilder.append(temp);
            }
            return stringBuilder.toString();
        }

        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> lists = new ArrayList<>();
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                String hash = getUnicodeHash(str.toCharArray());
                // System.out.println("hash==>" + hash);
                if (!map.containsKey(hash)) {
                    map.put(hash, new ArrayList<>());
                }
                map.get(hash).add(str);
            }

            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                lists.add(entry.getValue());
            }
            return lists;
        }
    }
}
