package leet_code;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sanyinchen on 19-9-19.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-19
 */

class Number_of_islands_200 {
    static class Solution {

        private void numIslandsHelper(char[][] grid, int i, int j) {

            if (i < 0 || j < 0) {
                return;
            }
            if (i >= grid.length) {
                return;
            }
            if (j >= grid[i].length) {
                return;
            }
            if (grid[i][j] == '0') {
                return;
            }
            if (grid[i][j] == '2') {
                return;
            }

            grid[i][j] = '2';
            numIslandsHelper(grid, i - 1, j);
            numIslandsHelper(grid, i + 1, j);
            numIslandsHelper(grid, i, j - 1);
            numIslandsHelper(grid, i, j + 1);


        }

        public int numIslands(char[][] grid) {
            int sum = 0;
            if (grid == null) {
                return sum;
            }
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == '1') {
                        sum++;
                        numIslandsHelper(grid, i, j);
                    }
                }
            }
            return sum;
        }
    }
}
