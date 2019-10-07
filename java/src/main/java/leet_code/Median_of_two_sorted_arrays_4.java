package leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by sanyinchen on 19-10-7.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-7
 */

class Median_of_two_sorted_arrays_4 {
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            List<Integer> res = new ArrayList<>();
            if (nums1 != null) {
                for (int i = 0; i < nums1.length; i++) {
                    res.add(nums1[i]);
                }
            }
            if (nums2 != null) {
                for (int i = 0; i < nums2.length; i++) {
                    res.add(nums2[i]);
                }
            }
            res.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            if (res.size() % 2 != 0) {
                return res.get(res.size() / 2);
            }
            double first = res.get(res.size() / 2);
            double second = res.get(res.size() / 2 - 1);
            return (first + second) / 2.0;
        }
    }
}
