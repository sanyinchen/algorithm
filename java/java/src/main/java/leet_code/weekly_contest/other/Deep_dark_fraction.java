package leet_code.weekly_contest.other;

/**
 * Created by sanyinchen on 19-9-24.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-24
 */

class Deep_dark_fraction {
    static class Solution {
        private Pair fractionHelper(int[] cont, int i) {
            if (i == cont.length - 2) {
                int x = cont[i] * cont[i + 1] + 1;
                int y = cont[i + 1];
                return new Pair(x, y);
            }

            Pair pair = fractionHelper(cont, i + 1);
            int x = pair.first;
            int y = pair.second;
            System.out.println("first:" + x + " second:" + y + " i:" + i + " cont[i]:" + cont[i]);
            int a = cont[i];
            System.out.println("new x:" + (a * y + y) + " y:" + x);
            return new Pair(a * x + y, x);
        }

        public int[] fraction(int[] cont) {
            if (cont.length == 1) {
                return new int[]{cont[0], 1};
            }
            Pair res = fractionHelper(cont, 0);
            int first = res.first;
            int second = res.second;
            int gcd = gcd(first, second);
            return new int[]{first / gcd, second / gcd};
        }

        public int gcd(int a, int b) {
            if (a < 0 || b < 0) {
                return -1;
            }
            if (b == 0) {
                return a;
            }
            while (a % b != 0) {
                int temp = a % b;
                a = b;
                b = temp;
            }
            return b;
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
        new Solution().fraction(new int[]{3, 2, 0, 2});
        new Solution().fraction(new int[]{0, 0, 3});
    }
}
