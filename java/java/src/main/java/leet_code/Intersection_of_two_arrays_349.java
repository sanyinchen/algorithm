package leet_code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Intersection_of_two_arrays_349 {
    static class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> numsSet1 = new HashSet<>();
            for (int i = 0; i < nums1.length; i++) {
                numsSet1.add(nums1[i]);
            }
            Set<Integer> resList = new HashSet<>();
            for (int j = 0; j < nums2.length; j++) {
                if (numsSet1.contains(nums2[j])) {
                    resList.add(nums2[j]);
                }
            }
            int[] res = new int[resList.size()];
            int i=0;
            for (int item:resList) {
                res[i++] = item;
            }
            return res;
        }

    }

    public static void main(String[] args) {
        int[] res = new Solution().intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        for (int item : res) {
            System.out.println("===>" + item);
        }
    }
}
