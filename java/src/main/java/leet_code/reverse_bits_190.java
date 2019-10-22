package leet_code;

public class reverse_bits_190 {
    public class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            int sum=0;
            for(int i=0;i<=31;i++){
                sum=sum+((1&(n>>i))<<(31-i));
            }
            return sum;
        }

    }
}
