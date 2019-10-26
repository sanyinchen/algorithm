package leet_code;

/**
 * Created by sanyinchen on 19-10-26.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-26
 */

class Candy_135 {
    static class Solution {
        public int candy(int[] ratings) {
            int[] candies = new int[ratings.length];
            for (int i = 0; i < ratings.length; i++) {
                candies[i] = 1;
            }
            boolean flag = true;
            while (flag) {
                flag = false;
                for (int i = 1; i < ratings.length; i++) {
                    if (ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]) {
                        candies[i]++;
                        flag = true;
                    }
                }
                for (int i = ratings.length - 1 - 1; i >= 0; i--) {
                    if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                        candies[i]++;
                        flag = true;
                    }
                }
            }
            int sum = 0;
            for (int i = 0; i < candies.length; i++) {
                sum += candies[i];
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        int[] ratings = new int[]{1, 2, 87, 87, 87, 2, 1};

        System.out.println("==>" + new Solution().candy(ratings));
    }
}
