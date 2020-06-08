package leet_code_part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sanyinchen on 20-6-8.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-6-8
 */

class Non_overlapping_intervals_435 {


    static class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            if (intervals.length <= 1) {
                return 0;
            }
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] - o2[0] == 0) {
                        return o1[1] - o2[1];
                    }
                    return o1[0] - o2[0];
                }
            });

            int count = 0;
            int end = intervals[0][1];
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] < end) {
                    end = Math.min(end, intervals[i][1]);
                    count++;
                } else {
                    end = intervals[i][1];
                }
            }
            return count;
        }



    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[][] inputs = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        int[][] inputs = {{1, 100}, {11, 22}, {1, 11}, {2, 12}};
        // [[0,2],[1,3],[2,4],[3,5],[4,6]]
        System.out.println(solution.eraseOverlapIntervals(inputs));

    }



}
