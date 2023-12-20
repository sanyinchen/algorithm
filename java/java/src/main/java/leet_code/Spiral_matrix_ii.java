package leet_code;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanyinchen on 19-9-25.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-25
 */

class Spiral_matrix_ii {
    static class Solution {

        private boolean isMarked(int[][] matrix, int i, int j, int n) {
            if (i >= n || j >= n || i < 0 || j < 0) {
                return true;
            }
            return matrix[i][j] != 0;
        }


        private void spiralOrderHelper(int[][] matrix, char cmd, int i, int j, int maxLength, int index, int n) {
            if (index == maxLength + 1) {
                return;
            }

            matrix[i][j] = index;
            System.out.println("maxLength:" + maxLength + " i:" + i + " j:" + j + " cmd:" + cmd + " " + matrix[i][j]);
            switch (cmd) {
                case 'R':
                    if (isMarked(matrix, i, j + 1, n)) {
                        spiralOrderHelper(matrix, 'D', i + 1, j, maxLength, index + 1, n);
                    } else {
                        spiralOrderHelper(matrix, 'R', i, j + 1, maxLength, index + 1, n);
                    }
                    break;
                case 'D':
                    if (isMarked(matrix, i + 1, j, n)) {
                        spiralOrderHelper(matrix, 'L', i, j - 1, maxLength, index + 1, n);
                    } else {
                        spiralOrderHelper(matrix, 'D', i + 1, j, maxLength, index + 1, n);
                    }
                    break;
                case 'L':

                    if (isMarked(matrix, i, j - 1, n)) {
                        spiralOrderHelper(matrix, 'U', i - 1, j, maxLength, index + 1, n);
                    } else {
                        spiralOrderHelper(matrix, 'L', i, j - 1, maxLength, index + 1, n);
                    }
                    break;
                case 'U':

                    if (isMarked(matrix, i - 1, j, n)) {
                        spiralOrderHelper(matrix, 'R', i, j + 1, maxLength, index + 1, n);
                    } else {
                        spiralOrderHelper(matrix, 'U', i - 1, j, maxLength, index + 1, n);
                    }
                    break;
            }
        }

        public int[][] generateMatrix(int n) {
            if (n == 0) {
                return null;
            }
            int[][] matrix = new int[n][n];

            spiralOrderHelper(matrix, 'R', 0, 0, n * n, 1, n);
            return matrix;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new Solution().generateMatrix(3);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
