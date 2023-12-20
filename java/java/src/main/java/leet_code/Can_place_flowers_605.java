package leet_code;

public class Can_place_flowers_605 {
    class Solution {
        private int getValue(int i, int[] flowerbed) {
            if (i >= flowerbed.length || i < 0) {
                return 0;
            }
            return flowerbed[i];
        }

        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int sum = 0;
            for (int i = 0; i < flowerbed.length; i++) {
                int pre = getValue(i - 1, flowerbed);
                int cur = getValue(i, flowerbed);
                int next = getValue(i + 1, flowerbed);
                if (pre == 0 && cur == 0 && next == 0) {
                    flowerbed[i] = 1;
                    sum++;
                }
            }
            return sum >= n;
        }
    }
}
