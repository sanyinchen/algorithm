package leet_code;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanyinchen on 19-9-14.
 * <p>
 * from https://leetcode-cn.com/problems/output-contest-matches/
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-14
 */

class Output_Contest_Matches_544 {
    static class Solution {

        private String findContestMatch(List<Pair<?>> pairs) {
            if (pairs == null || pairs.size() <= 1) {
                if (pairs == null || pairs.size() == 0) {
                    return "";
                }
                return pairs.get(0).toString();
            }
            List<Pair<?>> nextPairs = new ArrayList<>();
            int n = pairs.size();
            for (int i = 0, j = n - 1; i < j; i++, j--) {
                nextPairs.add(new Pair<Pair<?>>(pairs.get(i), pairs.get(j)));
            }
            return findContestMatch(nextPairs);
        }

        public String findContestMatch(int n) {
            List<Pair<?>> pairs = new ArrayList<>();

            for (int i = 0, j = n - 1; i < j; i++, j--) {
                pairs.add(new Pair<Integer>(i + 1, j + 1, true));
            }


            return findContestMatch(pairs);
        }

        public class Pair<T> {
            private T first;
            private T second;
            private boolean bottom = false;

            public Pair(T first, T second, boolean bottom) {
                this.first = first;
                this.second = second;
                this.bottom = bottom;
            }

            public Pair(T first, T second) {
                this.first = first;
                this.second = second;
            }

            public boolean isBottom() {
                return bottom;
            }

            public T getFirst() {
                return first;
            }

            public T getSecond() {
                return second;
            }

            public String toString() {
                return toString(this);
            }

            private String toString(Pair pair) {
                if (pair == null) {
                    return "";
                }

                if (pair.isBottom()) {
                    return "(" + pair.getFirst() + "," + pair.getSecond() + ")";
                }
                return "(" + toString((Pair) pair.getFirst()) + "," + toString((Pair) pair.getSecond()) + ")";
            }

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findContestMatch(8));
    }
}
