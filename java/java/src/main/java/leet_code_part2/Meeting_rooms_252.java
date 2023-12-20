package leet_code_part2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by sanyinchen on 20-6-15.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-6-15
 */

class Meeting_rooms_252 {
    class Solution {
        public boolean canAttendMeetings(int[][] intervals) {
            if (intervals.length <= 1) {
                return true;
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
            int pre = intervals[0][1];
            for (int i = 1; i < intervals.length; i++) {
                if (pre > intervals[i][0]) {
                    return false;
                }
                pre = intervals[i][1];
            }
            return true;
        }
    }

}
