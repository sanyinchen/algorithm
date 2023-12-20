package leet_code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sanyinchen on 19-9-21.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-21
 */

class Intersection_of_two_arrays_ii_350 {
    class Solution {

        private boolean isTheChar(List<Map<Integer, Integer>> pool, int check) {
            for (int k = 0; k < pool.size(); k++) {
                if (!pool.get(k).containsKey(check) || pool.get(k).get(check) <= 0) {
                    return false;
                }
            }
            for (int k = 0; k < pool.size(); k++) {
                pool.get(k).replace(check, pool.get(k).get(check) - 1);
            }
            return true;
        }

        public int[] intersect(int[] nums1, int[] nums2) {

            List<Map<Integer, Integer>> tempList = new ArrayList<>();
            Map<Integer, Integer> recorder = new HashMap<>();
            for (int i = 0; i < nums1.length; i++) {

                if (!recorder.containsKey(nums1[i])) {
                    recorder.put(nums1[i], 1);
                } else {
                    recorder.replace(nums1[i], recorder.get(nums1[i]) + 1);
                }

            }
            tempList.add(recorder);
            Map<Integer, Integer> recorder2 = new HashMap<>();
            for (int i = 0; i < nums2.length; i++) {
                if (!recorder2.containsKey(nums2[i])) {
                    recorder2.put(nums2[i], 1);
                } else {
                    recorder2.replace(nums2[i], recorder2.get(nums2[i]) + 1);
                }
            }
            tempList.add(recorder2);
            List<Integer> resList = new ArrayList<>();
            for (int i = 0; i < nums1.length; i++) {
                if (isTheChar(tempList, nums1[i])) {
                    resList.add(nums1[i]);
                }
            }
            int[] res = new int[resList.size()];
            for (int i = 0; i < res.length; i++) {
                res[i] = resList.get(i);
            }
            return res;
        }
    }
}
