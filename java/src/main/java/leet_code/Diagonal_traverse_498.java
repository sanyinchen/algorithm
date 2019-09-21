package leet_code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sanyinchen on 19-9-21.
 * <p>
 * from https://leetcode-cn.com/problems/diagonal-traverse/
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-21
 */

class Diagonal_traverse_498 {
    public static class Solution {
        private Set<String> visited = new HashSet<>();

        private String getKey(int i, int j) {
            return i + "_" + j;
        }

        private boolean isVisited(int i, int j, int[][] matrix) {
            return i < 0 || i >= matrix.length || j < 0 || j >= matrix[i].length || visited.contains(getKey(i, j));
        }

        private void findDiagonalOrderHelper(int[][] matrix, int i, int j, List<Integer> res) {

            if (i >= matrix.length || i < 0) {
                return;
            }
            if (j >= matrix[i].length || j < 0) {
                return;
            }


            String key = getKey(i, j);
            if (visited.contains(key)) {
                return;
            }
            // System.out.println("i==>" + i + " j:" + j + " key:" + key);
            res.add(matrix[i][j]);
            visited.add(key);

            if (i == 0 || i == matrix.length - 1) {
                if (!isVisited(i + 1, j - 1, matrix)) {
                    findDiagonalOrderHelper(matrix, i + 1, j - 1, res);
                } else {
                    if (i == matrix.length - 1) {
                        if (!isVisited(i - 1, j + 1, matrix)) {
                            findDiagonalOrderHelper(matrix, i - 1, j + 1, res);
                        } else {
                            findDiagonalOrderHelper(matrix, i, j + 1, res);
                        }
                    } else if (j == matrix[i].length - 1) {
                        findDiagonalOrderHelper(matrix, i + 1, j, res);
                    } else {
                        findDiagonalOrderHelper(matrix, i, j + 1, res);
                    }

                }
            } else {
                if (!isVisited(i + 1, j - 1, matrix)) {
                    findDiagonalOrderHelper(matrix, i + 1, j - 1, res);
                } else {
                    if (!isVisited(i - 1, j + 1, matrix)) {
                        findDiagonalOrderHelper(matrix, i - 1, j + 1, res);
                    } else {
                        if (j == 0) {
                            findDiagonalOrderHelper(matrix, i + 1, j, res);
                        }
                        if (j == matrix[i].length - 1) {
                            findDiagonalOrderHelper(matrix, i + 1, j, res);
                        }
                    }
                }
            }

        }

        public int[] findDiagonalOrder(int[][] matrix) {
            if (matrix == null) {
                return null;
            }

            visited.clear();
            List<Integer> res = new ArrayList<>();
            findDiagonalOrderHelper(matrix, 0, 0, res);
            int[] print = new int[res.size()];
            for (int i = 0; i < res.size(); i++) {
                print[i] = res.get(i);
            }
            return print;
        }
    }

    public static void main(String[] args) {
//        int[][] input = new int[][]{{2, 5}, {8, 4}, {0, -1}};
//        int[] res = new Solution().findDiagonalOrder(input);
//        for (int i : res) {
//            System.out.print(i);
//        }
        boolean flag1 = true;
        boolean flag2 = true;
        boolean flag3 = false;
        System.out.println(flag1 ^ flag2);

        System.out.println(flag1 ^ flag3);

        System.out.println(flag3 ^ flag3);
    }
}
