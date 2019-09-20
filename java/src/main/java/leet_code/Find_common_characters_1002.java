package leet_code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by sanyinchen on 19-9-20.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-20
 */

class Find_common_characters_1002 {
    static class Solution {
        private boolean isTheChar(List<Map<Character, Integer>> pool, char check) {
            for (int k = 0; k < pool.size(); k++) {
                if (!pool.get(k).containsKey(check) || pool.get(k).get(check) <= 0) {
                    return false;
                }
            }
            for (int k = 0; k < pool.size(); k++) {
                pool.get(k).replace(check, pool.get(k).get(check) - 1);
            }
            return true;
        }

        public List<String> commonChars(String[] array) {
            List<Map<Character, Integer>> tempList = new ArrayList<>();
            for (int i = 0; i < array.length; i++) {
                Map<Character, Integer> recorder = new HashMap<>();
                for (int j = 0; j < array[i].length(); j++) {
                    if (!recorder.containsKey(array[i].charAt(j))) {
                        recorder.put(array[i].charAt(j), 1);
                    } else {
                        recorder.replace(array[i].charAt(j), recorder.get(array[i].charAt(j)) + 1);
                    }
                }
                tempList.add(recorder);
            }
            List<String> res = new ArrayList<>();
            for (int i = 0; i < array[0].length(); i++) {
                if (isTheChar(tempList, array[0].charAt(i))) {
                    res.add(array[0].charAt(i) + "");
                }
            }


            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().commonChars(new String[]{"bella", "label", "roller"}));
    }
}
