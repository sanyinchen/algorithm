package leet_code.weekly_contest.weekly_155;

import java.util.Arrays;

/**
 * Created by sanyinchen on 19-9-21.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-21
 */

class How_many_apples_can_you_put_into_the_basket {
    public static class Solution {
        public int maxNumberOfApples(int[] arr) {
            if (arr == null) {
                return 0;
            }
            Arrays.sort(arr);
            int sum = 0;
            int number = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
                if (sum > 5000) {
                    return number;
                } else {
                    number++;
                }
            }
            return number;
        }
    }
}
