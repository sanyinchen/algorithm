package leet_code.weekly_contest.weekly_contest_162;

public class Cells_with_odd_values_in_a_matrix_5255 {
    static class Solution {
        public int oddCells(int n, int m, int[][] indices) {
            int[][] rect = new int[n][m];
            for (int i = 0; i < indices.length; i++) {
                int ri = indices[i][0];
                int ci = indices[i][1];
                // System.out.println(ri+" "+ci);
                for (int j = 0; j < m; j++) {
                    rect[ri][j]++;
                }
                for (int j = 0; j < n; j++) {
                    rect[j][ci]++;
                }
            }
            int sum = 0;
            for (int i = 0; i < rect.length; i++) {
                System.out.println();
                for (int j = 0; j < rect[0].length; j++) {
                    // System.out.print(rect[i][j]+" ");
                    if (rect[i][j] % 2 != 0) {
                        sum++;
                    }
                }
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.oddCells(2, 3, new int[][]{{0, 1}, {1, 1}}));
    }
}
