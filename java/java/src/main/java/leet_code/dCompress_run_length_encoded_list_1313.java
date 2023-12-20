package leet_code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sanyinchen on 20-1-21.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-1-21
 */

class dCompress_run_length_encoded_list_1313 {
    class Solution {
        public int[] decompressRLElist(int[] nums) {
            // Map<Integer, Integer> map = new HashMap<>();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length - 1; i += 2) {
                int number = nums[i];
                int v = nums[i + 1];
                // map.put(v, number);
                for (int j = 0; j < number; j++) {
                    list.add(v);
                }
                // System.out.println("number:" + number + " v:" + v);
            }

            int[] array = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                array[i] = list.get(i);
            }
            return array;

        }
    }
}
