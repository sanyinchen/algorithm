package leet_code.weekly_contest.weekly_157;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Intersection_of_three_sorted_arrays {
    class Solution {
        public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
            int[] cache = new int[2001];
            Set<Integer> temp = new HashSet<>();
            for (int i = 0; i < arr1.length; i++) {
                temp.add(arr1[i]);
            }
            for (Integer item : temp) {
                cache[item]++;
            }
            temp.clear();
            for (int i = 0; i < arr2.length; i++) {
                temp.add(arr2[i]);
            }
            for (Integer item : temp) {
                cache[item]++;
            }
            temp.clear();
            for (int i = 0; i < arr3.length; i++) {
                temp.add(arr3[i]);
            }
            for (Integer item : temp) {
                cache[item]++;
            }
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < cache.length; i++) {
                if (cache[i] == 3) {
                    res.add(i);
                }
            }
            return res;
        }
    }
}
