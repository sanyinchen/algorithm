package leet_code;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Sliding_window_maximum_239 {
    public static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            Deque<Pair> deque = new LinkedList<>();
            if (k == 0) {
                return nums;
            }
            List<Integer> res = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
//                while (!deque.isEmpty() && deque.peekFirst().index < i) {
//                    deque.pollFirst();
//                }
                for (int j = i - (k - 1); j >= 0 && j <= i && j < nums.length; j++) {
                   // System.out.println("j:" + j + " i:" + i);
                    int temp = nums[j];
                    while (!deque.isEmpty() && deque.peekLast().value <= temp) {
                        deque.pollLast();
                    }
                    deque.addLast(new Pair(j, temp));
                }
                if (!deque.isEmpty()) {
                    res.add(deque.pollFirst().value);
                }
            }
            int[] resArray = new int[res.size()];
            for (int i = 0; i < res.size(); i++) {
                resArray[i] = res.get(i);
            }
            return resArray;
        }

        private class Pair {
            int index;
            int value;

            public Pair(int index, int value) {
                this.index = index;
                this.value = value;
            }
        }
    }

    public static void main(String[] args) {
        int[] inputArgs = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] res = new Solution().maxSlidingWindow(inputArgs, 3);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
