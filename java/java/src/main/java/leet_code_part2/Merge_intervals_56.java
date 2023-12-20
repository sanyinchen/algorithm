package leet_code_part2;

import java.util.*;

public class Merge_intervals_56 {
    static class Solution {
        public int[][] merge(int[][] intervals) {
//            Arrays.sort(intervals, new Comparator<int[]>() {
//                @Override
//                public int compare(int[] o1, int[] o2) {
//                    return o1[0] - o2[0];
//                }
//            });
            for (int i = 0; i < intervals.length - 1; i++) {
                int[] item = intervals[i];
                for (int j = 0; j < intervals.length; j++) {

                    int[] itemJ = intervals[j];
                    List<int[]> list = new ArrayList<>();
                    list.add(item);
                    list.add(itemJ);
                    list.sort(new Comparator<int[]>() {
                        @Override
                        public int compare(int[] o1, int[] o2) {
                            return o1[0] - o2[0];
                        }
                    });
                    if (list.get(1)[0] > list.get(0)[1]) {
                        continue;
                    }
                    int first = Math.min(itemJ[0], item[0]);
                    int second = Math.max(item[1], itemJ[1]);
                    itemJ[0] = first;
                    itemJ[1] = second;

                    item[0] = first;
                    item[1] = second;
                }

            }
            List<int[]> list = new ArrayList<>();
            Set<String> cache = new HashSet<>();
            for (int i = 0; i < intervals.length; i++) {
                int[] item = intervals[i];
                String key = getKey(item[0], item[1]);
                if (cache.contains(key)) {
                    continue;

                }
                cache.add(key);
                list.add(item);
            }
            return list.toArray(new int[][]{});
        }

        private String getKey(int s, int e) {
            return s + "_" + e;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // int[][] inputs = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] inputs = new int[][]{{1, 4}, {4, 5}};
        int[][] res = solution.merge(inputs);
        for (int i = 0; i < res.length; i++) {
            int[] item = res[i];

            System.out.println(item[0] + " " + item[1]);
        }
    }
}

