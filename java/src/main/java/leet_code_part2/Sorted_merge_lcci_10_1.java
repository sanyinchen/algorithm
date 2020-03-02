package leet_code_part2;

import java.util.Arrays;

public class Sorted_merge_lcci_10_1 {
    class Solution {
        public void merge(int[] A, int m, int[] B, int n) {
            for (int i = m, j = 0; i < A.length && j < n; i++, j++) {
                A[i] = B[j];
            }
            Arrays.sort(A);
        }
    }
}
