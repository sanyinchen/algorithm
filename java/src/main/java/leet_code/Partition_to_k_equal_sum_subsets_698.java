package leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/**
 * Created by sanyinchen on 19-9-17.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-17
 */

class Partition_to_k_equal_sum_subsets_698 {
    static class Solution {

        private boolean res = false;

        private int getSum(List<Integer> nums) {
            int sum = 0;
            for (int item : nums) {
                sum += item;
            }
            return sum;
        }

        public void scanPartitionKSubsets(List<Integer> nums, int k, int groups, Stack<List<Integer>> group) {
            System.out.println("nums length:" + nums.size() + " k:" + k);
//            if (res) {
//                return true;
//            }
            if (groups == 1) {
                // group.push(nums);
                Stack<List<Integer>> newStack = (Stack<List<Integer>>) group.clone();
                if (nums.size() != 0) {

                    newStack.push(nums);

                }
                while (newStack.size() != 0) {
                    System.out.print(newStack.pop() + " ");
                }
                System.out.println("===========>" + group.size());
//
                return;


            }

            int offset = 0;
            // while (offset < nums.size()) {

            //offset++;
            //List<Integer> newList = new ArrayList<>();
            //newList.addAll(nums.subList(offset, nums.size()));
            //newList.addAll(nums.subList(0, offset));
            for (int i = 1; i <= k; i++) {
//                    if (res) {
//                        break;
//                    }
                // int max = (i + 1) <= nums.size() ? i + 1 : nums.size();
                if (i > nums.size()) {
                    continue;
                }
                System.out.println("i ==>" + i + " nums " + nums.size());
                group.push(nums.subList(0, i));
                //System.out.println("==>" + nums.subList(0, i));
                List<Integer> leftAll = nums.subList(i, nums.size());
                System.out.println("leftAll:" + leftAll.size());
//                    if (leftAll.size() == 0) {
//                        group.pop();
//                        continue;
//                    }
                scanPartitionKSubsets(leftAll, k, groups - 1, group);
                group.pop();

            }
            // }
            // res = flag;


        }

        public boolean canPartitionKSubsets(int[] nums, int k) {
            //res = false;
            List<Integer> list = new ArrayList<>();
            for (int i : nums) {
                list.add(i);
            }
//            Collections.sort(list, new Comparator<Integer>() {
//                @Override
//                public int compare(Integer o1, Integer o2) {
//                    return o2 - o1;
//                }
//            });
//            for (int i = 0; i < list.size(); i++) {
//                System.out.println("==============>");
//                List<Integer> newList = new ArrayList<>();
//                newList.addAll(list.subList(i, list.size()));
//                newList.addAll(list.subList(0, i));
//                scanPartitionKSubsets(newList, newList.size() - k, new Stack<>());
//            }
            scanPartitionKSubsets(list, list.size() - k + 1, k, new Stack<List<Integer>>());
            // System.out.println("res==>" + res);
            return res;
        }

    }

    public static void main(String[] args) {
        //new Solution().canPartitionKSubsets(new int[]{1, 2, 3, 4, 5}, 3);

        new Solution().canPartitionKSubsets(new int[]{5, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 3}, 15);
    }
}
