package leet_code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sort_characters_by_frequency_451 {
    static class Solution {
        public String frequencySort(String s) {
            Map<Character, Integer> number = new HashMap<>();
            char[] arrays = s.toCharArray();
            for (int i = 0; i < arrays.length; i++) {
                if (!number.containsKey(arrays[i])) {
                    number.put(arrays[i], 1);
                } else {
                    number.replace(arrays[i], number.get(arrays[i]) + 1);
                }
            }
            List<Pair> list = new ArrayList<>();
            for (int i = 0; i < arrays.length; i++) {
                list.add(new Pair(arrays[i], number.get(arrays[i])));
            }
            list.sort(new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    if (o2.times == o1.times) {
                        return o1.value - o2.value;
                    }
                    return o2.times - o1.times;
                }
            });

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                stringBuilder.append(list.get(i).value);
            }
            return stringBuilder.toString();
        }

        private class Pair {
            char value;
            int times;

            public Pair(char value, int times) {
                this.value = value;
                this.times = times;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.frequencySort("loveleetcode"));
    }

}
