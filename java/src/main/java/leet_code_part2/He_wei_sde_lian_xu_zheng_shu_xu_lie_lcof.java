package leet_code_part2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanyinchen on 20-3-6.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-3-6
 */

class He_wei_sde_lian_xu_zheng_shu_xu_lie_lcof {

    class Solution {
        public int[] convertListToArray(List<Integer> listResult) {
            int[] result = new int[listResult.size()];
            int i = 0;
            for (int num : listResult) {
                result[i++] = num;
            }
            return result;
        }

        public int[][] findContinuousSequence(int target) {
            List<int[]> lists = new ArrayList<>();
            for (int i = 1; i <= (target / 2 + 1); i++) {
                List<Integer> list = new ArrayList<>();
                int sum = 0;
                for (int j = i; j <= (target / 2 + 1); j++) {
                    sum += j;
                    list.add(j);
                    if (sum == target) {
                        lists.add(convertListToArray(list));
                        break;
                    }
                    if (sum > target) {
                        break;
                    }

                }
            }
            return lists.toArray(new int[lists.size()][]);
        }
    }
}
