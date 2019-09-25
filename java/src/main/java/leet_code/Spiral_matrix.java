package leet_code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sanyinchen on 19-9-25.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-25
 */

class Spiral_matrix {
    static class Solution {
        private List<Integer> res = new ArrayList<>();

        private boolean isMarked(int[][] matrix, int i, int j) {
            if (i >= matrix.length || j >= matrix[i].length || i < 0 || j < 0) {
                return true;
            }
            return matrix[i][j] == Integer.MAX_VALUE;
        }


        private void spiralOrderHelper(int[][] matrix, char cmd, int i, int j, int maxLength) {
            if (maxLength == res.size()) {
                return;
            }
            System.out.println("maxLength:" + maxLength + " i:" + i + " j:" + j + " cmd:" + cmd + " " + matrix[i][j] +
                    " list size:" + res.size());
            res.add(matrix[i][j]);
            matrix[i][j] = Integer.MAX_VALUE;

            switch (cmd) {
                case 'R':
                    if (isMarked(matrix, i, j + 1)) {
                        spiralOrderHelper(matrix, 'D', i + 1, j, maxLength);
                    } else {
                        spiralOrderHelper(matrix, 'R', i, j + 1, maxLength);
                    }
                    break;
                case 'D':
                    if (isMarked(matrix, i + 1, j)) {
                        spiralOrderHelper(matrix, 'L', i, j - 1, maxLength);
                    } else {
                        spiralOrderHelper(matrix, 'D', i + 1, j, maxLength);
                    }
                    break;
                case 'L':

                    if (isMarked(matrix, i, j - 1)) {
                        spiralOrderHelper(matrix, 'U', i - 1, j, maxLength);
                    } else {
                        spiralOrderHelper(matrix, 'L', i, j - 1, maxLength);
                    }
                    break;
                case 'U':

                    if (isMarked(matrix, i - 1, j)) {
                        spiralOrderHelper(matrix, 'R', i, j + 1, maxLength);
                    } else {
                        spiralOrderHelper(matrix, 'U', i - 1, j, maxLength);
                    }
                    break;
            }
        }

        public List<Integer> spiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return new ArrayList<>();
            }
            int maxLength = matrix.length * matrix[0].length;
            spiralOrderHelper(matrix, 'R', 0, 0, maxLength);
            return res;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("==>" + new Solution().spiralOrder(matrix));
    }
}
