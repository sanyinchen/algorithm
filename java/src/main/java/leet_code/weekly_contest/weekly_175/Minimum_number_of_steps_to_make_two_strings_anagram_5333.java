package leet_code.weekly_contest.weekly_175;

import java.util.ArrayList;
import java.util.List;

// todo fail
public class Minimum_number_of_steps_to_make_two_strings_anagram_5333 {
    static class Solution {
        public int minSteps(String s, String t) {
            int[] cacheS = new int['z' + 1];
            int[] cacheT = new int['z' + 1];
            for (int i = 0; i < s.length(); i++) {
                cacheS[s.charAt(i)]++;
            }
            for (int i = 0; i < t.length(); i++) {
                cacheT[t.charAt(i)]++;
            }
            int sum = 0;
            int sameDiff = 0;
            int sameDiffAbs = 0;
            List<Pair> samePairs = new ArrayList<>();
            for (int i = 0; i < 'z'; i++) {
                if (cacheS[i] != 0 && cacheT[i] != 0) {
                    // samePairs.add(new Pair(cacheS[i], cacheT[i]));
                    int diff = cacheS[i] - cacheT[i];
                    sameDiff += diff;
                    sameDiffAbs += Math.abs(diff);
                }
                if (cacheS[i] != 0 && cacheT[i] == 0) {
                    sum += cacheS[i];
                }
            }
            sum += ((sameDiffAbs - sameDiff) / 2 + sameDiff);
//            if (sameDiff == 0) {
//                sum += sameDiffAbs / 2;
//            } else {
//                sum += (sameDiff / 2+)
//            }
           // System.out.println("sum:" + sum);
            return Math.abs(sum);
        }

        private class Pair {
            int first;
            int second;

            public Pair(int first, int second) {
                this.first = first;
                this.second = second;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int number = solution.minSteps("gctcxyuluxjuxnsvmomavutrrfb", "qijrjrhqqjxjtprybrzpyfyqtzf");
        System.out.println(number);
    }
}
