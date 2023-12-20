package leet_code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by sanyinchen on 20-1-6.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-1-6
 */

class Four_sum_ii_454 {
    static class Solution {
        public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
            int sum = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A.length; j++) {
                    int tempSUm = A[i] + B[j];
                    if (!map.containsKey(tempSUm)) {
                        map.put(tempSUm, 1);
                    } else {
                        map.replace(tempSUm, map.get(tempSUm) + 1);
                    }
                }
            }

            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A.length; j++) {
                    int tepSum = C[i] + D[j];
                    int require = 0 - tepSum;
                    if (map.containsKey(require)) {
                        sum += map.get(require);
                    }
                }
            }

            return sum;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = new int[]{1, 2};
        int[] B = new int[]{-2, -1};
        int[] C = new int[]{-1, 2};
        int[] D = new int[]{0, 2};
        int sum = solution.fourSumCount(A, B, C, D);
        System.out.println("sum:" + sum);
    }
}
