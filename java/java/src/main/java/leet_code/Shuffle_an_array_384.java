package leet_code;

import java.util.Random;

/**
 * Created by sanyinchen on 19-10-24.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-24
 */

class Shuffle_an_array_384 {
    class Solution {
        int[] copyed;
        final int[] reset;

        public Solution(int[] nums) {
            reset = nums.clone();
            copyed = reset.clone();
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            copyed = reset.clone();
            return copyed;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            for (int i = 0; i < copyed.length; i++) {
                int random = new Random().nextInt(copyed.length - i - 1) + i;
                if (random == i) {
                    continue;
                }
                int temp = copyed[i];
                copyed[i] = copyed[random];
                copyed[random] = temp;
            }
            return copyed;
        }
    }

}
