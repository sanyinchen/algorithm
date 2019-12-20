package leet_code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Practical_application_design_the_key_ {
    static class Solution {
        private boolean isValid(String str) {
            Set<Character> set = new HashSet<>();
            for (char item : str.toCharArray()) {
                if (set.contains(item)) {
                    return false;
                }
                set.add(item);
            }
            return true;
        }

        public List<List<String>> groupStrings(String[] strings) {
            Map<Integer, List<String>> map = new HashMap<>();
            for (String str : strings) {
                int length = str.length();
                if (isValid(str)) {
                    if (!map.containsKey(length)) {
                        map.put(length, new ArrayList<>());
                    }
                    map.get(length).add(str);
                }
            }

            List<List<String>> res = new ArrayList<>();
            for (Map.Entry<Integer, List<String>> item : map.entrySet()) {
                List<List<String>> tempList = new ArrayList<>();
                List<String> tempItem = item.getValue();

            

                // res.add(item.getValue());
            }


            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> lists = solution.groupStrings(new String[]{"ab", "ba"});
        lists.forEach(item -> {
            System.out.println(item);
        });
    }

}
