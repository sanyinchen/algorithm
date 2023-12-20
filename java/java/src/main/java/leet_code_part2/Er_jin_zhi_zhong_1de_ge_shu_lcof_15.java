package leet_code_part2;

public class Er_jin_zhi_zhong_1de_ge_shu_lcof_15 {
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            String str = Integer.toBinaryString(n);
            int number = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '1') {
                    number++;
                }
            }
            return number;
        }
    }
}
