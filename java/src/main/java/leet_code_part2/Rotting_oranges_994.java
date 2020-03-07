package leet_code_part2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by sanyinchen on 20-3-4.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-3-4
 */

class Rotting_oranges_994 {
    static class Solution {

        public int orangesRotting(int[][] grid) {

            int number = 0;
            int M = grid.length;
            int N = grid[0].length;
            LinkedList<int[]> queue = new LinkedList<>();
            int count = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 2) {
                        queue.push(new int[]{i, j});
                    }
                    if (grid[i][j] == 1) {
                        count++;
                    }
                }
            }
            while (count > 0 && !queue.isEmpty()) {
                number++;
                int size = queue.size();
                while (size-- > 0) {

                    int[] orange = queue.poll();
                    int r = orange[0];
                    int c = orange[1];
                    if (r - 1 >= 0 && grid[r - 1][c] == 1) {
                        grid[r - 1][c] = 2;
                        count--;
                        queue.add(new int[]{r - 1, c});
                    }
                    if (r + 1 < M && grid[r + 1][c] == 1) {
                        grid[r + 1][c] = 2;
                        count--;
                        queue.add(new int[]{r + 1, c});
                    }
                    if (c - 1 >= 0 && grid[r][c - 1] == 1) {
                        grid[r][c - 1] = 2;
                        count--;
                        queue.add(new int[]{r, c - 1});
                    }
                    if (c + 1 < N && grid[r][c + 1] == 1) {
                        grid[r][c + 1] = 2;
                        count--;
                        queue.add(new int[]{r, c + 1});
                    }


                }
            }

            if (count == 0) {
                return number;
            }
            return -1;
        }

        public class Pair {
            int x;
            int y;

            public Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.orangesRotting(new int[][]{{1, 2}});
        System.out.println(res);
    }
}
