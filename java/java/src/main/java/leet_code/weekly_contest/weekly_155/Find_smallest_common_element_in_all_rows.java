package leet_code.weekly_contest.weekly_155;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sanyinchen on 19-9-21.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-21
 */

class Find_smallest_common_element_in_all_rows {
    static class Solution {

        private boolean isContained(List<Set<Integer>> list, int check) {
            for (int i = 0; i < list.size(); i++) {
                if (!list.get(i).contains(check)) {
                    return false;
                }
            }
            return true;
        }

        public int smallestCommonElement(int[][] mat) {
            if (mat == null) {
                return -1;
            }
            List<Set<Integer>> list = new ArrayList<>();
            for (int i = 0; i < mat.length; i++) {
                Set<Integer> tempSet = new HashSet<>();
                for (int j = 0; j < mat[i].length; j++) {
                    tempSet.add(mat[i][j]);
                }
                list.add(tempSet);
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < mat[0].length; i++) {
                if (isContained(list, mat[0][i])) {
                    if (min > mat[0][i]) {
                        min = mat[0][i];
                    }
                }
            }

            return min == Integer.MAX_VALUE ? -1 : min;
        }
    }
}
