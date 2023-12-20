package leet_code.weekly_contest.weekly_156;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Unique_number_of_occurrences {
    static class Solution {
        public boolean uniqueOccurrences(int[] arr) {
            if (arr == null || arr.length <= 1) {
                return true;
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                if (!map.containsKey(arr[i])) {
                    map.put(arr[i], 1);
                } else {
                    int temp = map.get(arr[i]);
                    map.put(arr[i], temp + 1);
                }
            }
            Set<Integer> numbersCheck = new HashSet<>();
            Iterator<Integer> iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                int index = iterator.next();
                if (!numbersCheck.contains(map.get(index))) {

                   // System.out.println("index:" + index + " " + " value:" + map.get(index));
                    numbersCheck.add(map.get(index));
                } else {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        int[] inputs = new int[]{1, 2, 2, 1, 1, 3};
        System.out.println("==>" + (new Solution().uniqueOccurrences(inputs)));
    }
}
