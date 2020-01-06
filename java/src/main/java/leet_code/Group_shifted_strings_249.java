package leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Group_shifted_strings_249 {
    static class Solution {

        private String getUnicodeHash(char[] chars) {
            if (chars.length == 0) {
                return "";
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("0").append("#");
            for (int i = 1; i < chars.length; i++) {
                int shift = (chars[i] - chars[0] + 26) % 26;
                stringBuilder.append(shift).append("#");
            }
            return stringBuilder.toString();
        }


        public List<List<String>> groupStrings(String[] strings) {
            Map<Integer, List<Pair>> map = new HashMap<>();
            for (String str : strings) {
                int length = str.length();
                if (!map.containsKey(length)) {
                    map.put(length, new ArrayList<>());
                }
                List<Pair> pairs = map.get(length);
                char[] chars = str.toCharArray();
                String hash = getUnicodeHash(chars);
                boolean hasAdded = false;
                for (Pair pair : pairs) {
                    boolean interrupted = false;
                    for (String inStr : pair.items) {
                        // System.out.println("compare:" + getSortStr(inStr.toCharArray()));
                        String hascode = getUnicodeHash(inStr.toCharArray());
                        if (inStr.length() != length || !hash.equals(hascode)) {
                            interrupted = true;
                            break;
                        }
                    }
                    if (interrupted) {
                        continue;
                    }
                    pair.hascodes.add(hash);
                    pair.items.add(str);
                    hasAdded = true;
                    break;
//
                }
                if (!hasAdded) {
                    Pair pair = new Pair();
                    pair.hascodes.add(hash);
                    pair.items.add(str);
                    pairs.add(pair);
                }

            }

            List<List<String>> res = new ArrayList<>();
            for (Map.Entry<Integer, List<Pair>> item : map.entrySet()) {
                List<Pair> pairs = item.getValue();
                for (Pair pair : pairs) {
                    res.add(pair.items);
                }
            }


            return res;
        }

        private class Pair {
            Set<String> hascodes;
            List<String> items;

            public Pair() {
                hascodes = new HashSet<>();
                items = new ArrayList<>();
            }
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
