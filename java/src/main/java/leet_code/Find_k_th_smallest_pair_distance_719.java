package leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Find_k_th_smallest_pair_distance_719 {
    static class Solution {
        public int smallestDistancePair(int[] nums, int k) {
            List<Integer> res = new LinkedList<>();
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    int dis = Math.abs(nums[i] - nums[j]);
                    res.add(dis);
                }
            }
            res.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            return res.get(k - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = new int[]{1, 3, 1};
//        System.out.println(solution.smallestDistancePair(nums, 1));
        int[] nums = new int[]{62, 100, 4};
        System.out.println(solution.smallestDistancePair(nums, 2));
    }
}
