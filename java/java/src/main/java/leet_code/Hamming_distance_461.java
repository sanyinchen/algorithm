package leet_code;

public class Hamming_distance_461 {
    class Solution {
        public int hammingDistance(int x, int y) {
            int v = x ^ y;
            int sum = 0;
            while (v != 0) {
                sum++;
                v &= (v - 1);
            }
            return sum;
        }
    }
}
