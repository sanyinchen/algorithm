package leet_code_part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge_intervals_56 {
    class Solution {
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
                    if (list.get(1)[0]>list.get(0)[0]){
                        continue;
                    }
                    int first = Math.min(itemJ[0], item[0]);
                    int second = Math.max(item[1], itemJ[1]);
                    itemJ[0] = first;
                    itemJ[1] = second;
                }

            }
            return intervals;
        }
    }
}
