package leet_code.weekly_contest.weekly_contest_161;

public class Minimum_swaps_to_make_strings_equal_5247 {
   static class Solution {
        public int minimumSwap(String s1, String s2) {
            int ax = 0;
            int ay = 0;
            int bx = 0;
            int by = 0;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == 'x') {
                    ax++;
                } else {
                    ay++;
                }
            }
            for (int i = 0; i < s2.length(); i++) {
                if (s2.charAt(i) == 'x') {
                    bx++;
                } else {
                    by++;
                }
            }

            if ((ax + bx) % 2 != 0 || (ay + by) % 2 != 0 || Math.abs(ax - bx) != Math.abs(ay - by)) {
                return -1;
            }

            char[] a = s1.toCharArray();
            char[] b = s2.toCharArray();

            int diff = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] != b[i]) {
                    diff++;
                }
            }
            int sum = 0;
            int addDiff = Math.abs(ax - bx);
            if (addDiff != 0) {
                diff -= addDiff * 2;
                sum += addDiff / 2;
            }
            if (diff > 0) {
                if (diff > 2) {
                    diff = 2;
                    sum += (diff - 2) / 2;
                }
                sum += diff;
            }

            return sum;

        }
    }

    public static void main(String[] args){
       System.out.print(new Solution().minimumSwap("xxyyxyxyxx","xyyxyxxxyx"));
    }
}
