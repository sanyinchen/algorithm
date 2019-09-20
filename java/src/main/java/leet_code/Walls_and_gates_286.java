package leet_code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by sanyinchen on 19-9-19.
 * <p>
 * from https://leetcode-cn.com/problems/walls-and-gates/
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-19
 */

class Walls_and_gates_286 {
    static class Solution {


        public void wallsAndGatesHelper(int[][] rooms, int i, int j, int step) {
            if (i < 0 || j < 0) {
                return;
            }
            if (i >= rooms.length) {
                return;
            }
            if (j >= rooms[i].length) {
                return;
            }
            if (rooms[i][j] < step) {
                return;
            }
            rooms[i][j] = step;
            // 上
            wallsAndGatesHelper(rooms, i - 1, j, step + 1);
            // 下
            wallsAndGatesHelper(rooms, i + 1, j, step + 1);
            // 左
            wallsAndGatesHelper(rooms, i, j - 1, step + 1);
            // 右
            wallsAndGatesHelper(rooms, i, j + 1, step + 1);

        }

        public void wallsAndGates(int[][] rooms) {
            if (rooms == null) {
                return;
            }
            for (int i = 0; i < rooms.length; i++) {
                for (int j = 0; j < rooms[i].length; j++) {
                    if (rooms[i][j] == 0) {
                        wallsAndGatesHelper(rooms, i, j, 0);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] x = new int[][]{{2147483647, -1, 0, 2147483647}, {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1,
                        2147483647, -1}, {0, -1, 2147483647, 2147483647}};
        // System.out.println(x.length);
        new Solution().wallsAndGates(x);
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length; j++) {
                System.out.print(x[i][j] + " ");
            }
            System.out.println();
        }
    }
}
