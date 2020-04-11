package leet_code_part2;

import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Zigzag_conversion_6 {
    static class Solution {
        private char[][] map;

        private void convertHelper(String s, int i, boolean down, int ii, int jj) {
            if (i >= s.length()) {
                return;
            }

            if (down) {
                ii++;
            } else {
                ii--;
                jj++;
            }

            if (ii >= map.length) {
                down = false;
                ii = map.length - 2;
                jj++;
            }
            if (ii <= 0) {
                ii = 0;
                down = true;
            }
            map[ii][jj] = s.charAt(i);
            convertHelper(s, i + 1, down, ii, jj);
        }

        public String convert(String s, int numRows) {
            if (numRows <= 1) {
                return s;
            }
            map = new char[numRows][s.length()];
            convertHelper(s, 0, true, -1, 0);
            StringBuilder str = new StringBuilder();
            for (int ii = 0; ii < map.length; ii++) {
                for (int jj = 0; jj < map[ii].length; jj++) {
                    if (map[ii][jj] != Character.MIN_VALUE) {
                        str.append(map[ii][jj]);
                    }
                }
                System.out.println();
            }
            return str.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convert("ABCD", 2));
    }
}
