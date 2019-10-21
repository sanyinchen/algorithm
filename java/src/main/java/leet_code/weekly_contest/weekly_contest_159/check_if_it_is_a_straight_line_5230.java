package leet_code.weekly_contest.weekly_contest_159;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class check_if_it_is_a_straight_line_5230 {
    class Solution {
        public boolean checkStraightLine(int[][] coordinates) {

            if (coordinates.length <= 1) {
                return true;
            }
            float k = Integer.MAX_VALUE;

            for (int i = 1; i < coordinates.length; i++) {
                int[] point = coordinates[i];
                float pointx = (float) point[0];
                float pointy = (float) point[1];

                int[] pointPre = coordinates[i - 1];
                float pointPrex = (float) pointPre[0];
                float pointPrey = (float) pointPre[1];

                float temp = 0;
                if ((pointx - pointPrex) != 0) {
                    temp = (pointy - pointPrey) / (pointx - pointPrex);
                } else if (pointy - pointPrey != 0) {
                    temp = (pointx - pointPrex) / (pointy - pointPrey);
                }

                if (k == Integer.MAX_VALUE) {
                    k = temp;
                    continue;
                }
                if (k!=temp){
                    return false;
                }
            }
            return true;
        }

    }
}
