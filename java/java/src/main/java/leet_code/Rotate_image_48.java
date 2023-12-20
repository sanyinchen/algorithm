package leet_code;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sanyinchen on 19-10-13.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-13
 */

class Rotate_image_48 {
    static class Solution {
        private void swap(int[][] matrix, int x, int y, int x2, int y2) {
            if (x < 0 || y < 0) {
                return;
            }
            if (x >= matrix.length || y >= matrix[x].length) {
                return;
            }
            if (x2 < 0 || y2 < 0) {
                return;
            }
            if (x2 >= matrix.length || y2 >= matrix[x2].length) {
                return;
            }
            int temp = matrix[x][y];
            matrix[x][y] = matrix[x2][y2];
            matrix[x2][y2] = temp;
        }

        public void rotate(int[][] matrix) {
            for (int i = 0; i < matrix.length / 2; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    int x = i;
                    int y = j;

                    int x2 = matrix[i].length - x - 1;
                    int y2 = y;


                    swap(matrix, x, y, x2, y2);
                }
            }
            for (int i = 0; i < matrix.length; i++) {
                System.out.println();
                for (int j = 0; j < matrix.length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println("");
            System.out.println("===========");
            Set<String> cache = new HashSet<>();
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    for (int ii = j, jj = i; jj < matrix.length && ii >= 0; ii--, jj++) {

                        if (cache.contains(ii + "_" + jj)) {
                            continue;
                        }
                        cache.add(ii + "_" + jj);
                        cache.add(jj + "_" + ii);
                        System.out.println("==> x,y " + ii + " " + jj + " [" + matrix[ii][jj] + "] =>" + jj + " " + ii
                                + " " + matrix[jj][ii]);
                        swap(matrix, ii, jj, jj, ii);
                    }
                }

            }
        }
    }

    public static void main(String[] args) {
        int[][] inputs = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Solution solution = new Solution();
        solution.rotate(inputs);
        for (int i = 0; i < inputs.length; i++) {
            System.out.println();
            for (int j = 0; j < inputs.length; j++) {
                System.out.print(inputs[i][j] + " ");
            }
        }
    }
}
