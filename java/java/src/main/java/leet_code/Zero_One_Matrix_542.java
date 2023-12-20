package leet_code;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by sanyinchen on 20-1-14.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-1-14
 */

class Zero_One_Matrix_542 {
    static class Solution {

        private boolean isValid(int[][] matrix, int x, int y) {
            if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length) {
                return false;
            }
            return true;
        }

        private void bfs(int[][] matrix, Pair pair) {
            Queue<Pair> queue = new LinkedList<>();
            queue.add(pair);
            int number = -1;
            while (!queue.isEmpty()) {

                number++;
                int size = queue.size();
                while (size-- > 0) {
                    Pair child = queue.poll();
                    if (matrix[child.first][child.second] == 0) {
                        matrix[pair.first][pair.second] = (number);
                        return;
                    }

                    int x = child.first;
                    int y = child.second;
                    if (isValid(matrix, x + 1, y)) {
                        queue.add(new Pair(x + 1, y));
                    }

                    if (isValid(matrix, x - 1, y)) {
                        queue.add(new Pair(x - 1, y));
                    }

                    if (isValid(matrix, x, y + 1)) {
                        queue.add(new Pair(x, y + 1));
                    }

                    if (isValid(matrix, x, y - 1)) {
                        queue.add(new Pair(x, y - 1));
                    }

                }
            }

        }

        public int[][] updateMatrix(int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    bfs(matrix, new Pair(i, j));
                }
            }

            return matrix;

        }

        private class Pair {
            int first;
            int second;

            public Pair(int first, int second) {
                this.first = first;
                this.second = second;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] temp = solution.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}});
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                System.out.print(temp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
