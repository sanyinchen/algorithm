package leet_code.weekly_contest.weekly_158;

import java.util.ArrayList;
import java.util.List;

// todo fail
public class Queens_that_can_attack_the_king_5223 {
    static class Solution {

        public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
            boolean[][] block = new boolean[8][8];
            int targetX = king[0];
            int targetY = king[1];
            for (int i = 0; i < queens.length; i++) {
                int x = queens[i][0];
                int y = queens[i][1];

                if (x < targetX) {
                    if (x - 1 > 0 && !block[x - 1][y]) {
                        for (int j = x - 1; j >= 0; j--) {
                            block[j][y] = true;
                        }
                    }
                } else {
                    if (x + 1 < 8 && !block[x + 1][y]) {
                        for (int j = x + 1; j < 8; j++) {
                            block[j][y] = true;
                        }
                    }
                }
                if (y < targetY) {
                    if (y - 1 >= 0 && !block[x][y - 1]) {
                        for (int j = y - 1; j >= 0; j--) {
                            block[x][j] = true;
                        }
                    }
                } else {
                    if (y + 1 < 8 && !block[x][y + 1]) {
                        for (int j = y + 1; j < 8; j++) {
                            block[x][j] = true;
                        }
                    }
                }

                if (x >= targetX && y >= targetY) {

                }

                if (x >= targetX && y < targetY) {

                }


                if (x >= targetX && y >= targetY) {

                }


                if (x >= targetX && y >= targetY) {

                }
            }

            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < queens.length; i++) {

                int x = queens[i][0];
                int y = queens[i][1];
                List<Integer> item = new ArrayList<>();

                if (!block[x][y]) {
                    item.add(queens[i][0]);
                    item.add(queens[i][1]);
                    res.add(item);
                }
            }
            return res;
        }


    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] queens = new int[][]{{0, 1}, {1, 0}, {4, 0}, {0, 4}, {3, 3}, {2, 4}};
        int[] king = new int[]{0, 0};
        List<List<Integer>> res = solution.queensAttacktheKing(queens, king);
        for (List<Integer> item : res) {
            System.out.println("==>" + item.get(0) + " " + item.get(1));
        }

    }

}
