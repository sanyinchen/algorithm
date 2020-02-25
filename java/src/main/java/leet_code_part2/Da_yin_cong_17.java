package leet_code_part2;

public class Da_yin_cong_17 {
    class Solution {
        public int[] printNumbers(int n) {
            int max = 10;
            for (int i = 1; i < n; i++) {
                max *= 10;
            }
            int[] res = new int[max - 1];
            for (int i = 0; i < max - 1; i++) {
                res[i] = i + 1;
            }
            return res;
        }
    }
}
