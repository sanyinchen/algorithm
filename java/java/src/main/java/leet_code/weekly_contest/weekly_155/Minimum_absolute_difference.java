package leet_code.weekly_contest.weekly_155;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Minimum_absolute_difference {
    static class Solution {
        public List<List<Integer>> minimumAbsDifference(int[] arr) {
            Arrays.sort(arr);
            int min = Integer.MAX_VALUE;
            for (int i = 1; i < arr.length; i++) {
                if (Math.abs(arr[i] - arr[i - 1]) < min) {
                    min = arr[i] - arr[i - 1];
                }
            }
            List<List<Integer>> list = new ArrayList<>();

            for (int i = 1; i < arr.length; i++) {
                if (Math.abs(arr[i] - arr[i - 1]) == min) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(arr[i - 1]);
                    temp.add(arr[i]);
                    list.add(temp);
                }
            }
            return list;
        }
    }
}
