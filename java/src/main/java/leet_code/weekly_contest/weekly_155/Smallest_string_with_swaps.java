package leet_code.weekly_contest.weekly_155;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

// todo fail
public class Smallest_string_with_swaps {
    static class Solution {
        public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
            if (pairs.size() == 0) {
                return s;
            }
            HashMap<Integer, Character> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                map.put(i, s.charAt(i));
            }
            int length = pairs.size();
            List<String> res = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                List<Integer> item = pairs.get(i);
                int first = item.get(0);
                int second = item.get(1);
                char temp = map.get(first);
                map.replace(first, map.get(second));
                map.replace(second, temp);
                StringBuilder str = new StringBuilder();

                for (int j = 0; j < s.length(); j++) {
                    str.append(map.get(j));
                }
                res.add(str.toString());
            }
            res.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            return res.get(0);

        }
    }

    public static void main(String[] args) {
        List<List<Integer>> inputs = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(0);
        temp.add(3);
        inputs.add(temp);

        temp = new ArrayList<>();
        temp.add(1);
        temp.add(2);
        inputs.add(temp);

        temp = new ArrayList<>();
        temp.add(0);
        temp.add(2);
        inputs.add(temp);

        System.out.println(new Solution().smallestStringWithSwaps("dcab", inputs));
    }
}
