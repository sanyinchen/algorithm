package leet_code.weekly_contest.weekly_156;

public class Remove_all_adjacent_duplicates_in_string_ii_5206 {
    static class Solution {

        private String removeDuplicatesHelper(String s, int k) {
            if (s.length() == 0) {
                return "";
            }
            if (s.length() < k) {
                return s;
            }
            int[] dp = new int[s.length()];
            char[] sArray = s.toCharArray();
            int length = dp.length;
            dp[0] = 1;
            for (int i = 1; i < length; i++) {
                if (sArray[i] == sArray[i - 1]) {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = 1;
                }
                System.out.println("i:" + i + " v:" + dp[i]);
            }
            int max = -1;
            int min = -1;
            for (int i = 0; i < length; i++) {
                if (dp[i] == k) {
                    max = i;
                    break;
                }
            }
            if (max == -1) {
                return s;
            }
            min = max - k + 1;
            String subStr = s;
            System.out.println("min:" + min + " max:" + max);
            if (max != -1) {
                subStr = s.substring(0, min) + s.substring(max + 1);
            }
            return removeDuplicatesHelper(subStr, k);
        }

        public String removeDuplicates(String s, int k) {

            return removeDuplicatesHelper(s,k);
        }
    }

    public static void main(String[] args) {
        String s = "deeedbbcccbdaa";
        System.out.println("===>" + new Solution().removeDuplicates(s, 3));
    }
}
