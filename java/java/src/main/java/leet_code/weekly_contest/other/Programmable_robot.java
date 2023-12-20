package leet_code.weekly_contest.other;

import java.util.*;

/**
 * Created by sanyinchen on 19-9-24.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-24
 */

class Programmable_robot {
    static class Solution {

        public boolean robot(String command, int[][] obstacles, int x, int y) {
            Set<Long> cache = new HashSet<>();
            if (command.length() == 0) {
                return false;
            }
            long x0 = 0;
            long y0 = 0;
            cache.add(0L);
            for (int i = 0; i < command.length(); i++) {
                if (command.charAt(i) == 'U') {
                    y0++;
                } else {
                    x0++;
                }
                cache.add(((x0 << 32) | y0));
            }
            long scale = Math.min(x / x0, y / y0);
            long newX = (long) x - (long) (scale * x0);
            long newY = (long) y - (long) (scale * y0);
            long flag = newX << 32 | newY;
            if (!cache.contains(flag)) {
                return false;
            }
            for (int i = 0; i < obstacles.length; i++) {
                int[] item = obstacles[i];
                if (item[0] > x || item[1] > y) {
                    continue;
                }
                scale = Math.min(item[0] / x0, item[1] / y0);
                newX = (long) item[0] - (long) (scale * x0);
                newY = (long) item[1] - (long) (scale * y0);
                flag = newX << 32 | newY;
                if (cache.contains(flag)) {
                    return false;
                }
            }


            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] input = new int[][]{{2, 2}};
        String command = "URR";
        System.out.println(solution.robot(command, input, 3, 2));
    }
}
