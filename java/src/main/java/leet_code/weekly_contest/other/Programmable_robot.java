package leet_code.weekly_contest.other;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

/**
 * Created by sanyinchen on 19-9-24.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-24
 */

class Programmable_robot {
    class Solution {
        private Set<String> obstaclesSet = new HashSet<>();

        public boolean robot(String command, int[][] obstacles, int x, int y) {
            obstaclesSet.clear();
            for (int i = 0; i < obstacles.length; i++) {
                int[] item = obstacles[i];
                obstaclesSet.add(item[0] + "_" + item[1]);
            }
            LinkedList<Character> all = new LinkedList<>();
            Stack<Character> item = new Stack<>();
            for (int i = 0; i < command.length(); i++) {
                item.push(command.charAt(i));
            }
            all.addAll(item);
            int x0 = 0;
            int y0 = 0;
            while (!all.isEmpty()) {
                if (x0 == x && y == y0) {
                    return true;
                }
                if (x0 > x || y0 > y) {
                    return false;
                }
                if (obstaclesSet.contains(x0 + "_" + y0)) {
                    return false;
                }
                char comd = all.poll();
                if (comd == 'U') {
                    y0++;
                }
                if (comd == 'R') {
                    x0++;
                }
                if (all.isEmpty()) {
                    all.addAll(item);
                }
            }
            return false;
        }
    }
}
