package leet_code_part2;


import java.util.Arrays;

public class Xuan_zhuan_shu_zu_de_zui_xiao_shu_zi_lcof_11 {
    class Solution {
        public int minArray(int[] numbers) {
            Arrays.sort(numbers);
            return numbers[0];
        }
    }
}
