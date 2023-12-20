package leet_code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Find_k_closest_elements_658 {
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    if (o1.dis == o2.dis) {
                        return o2.value - o1.value;
                    }
                    return o2.dis - o1.dis;
                }
            });
            for (int i = 0; i < arr.length; i++) {
                queue.add(new Pair(arr[i], Math.abs(x - arr[i])));
                if (queue.size() > k) {
                    queue.poll();
                }
            }
            List<Integer> res = new ArrayList<>();
            while (!queue.isEmpty()) {
                res.add(queue.poll().value);
            }
            res.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            return res;
        }

        private class Pair {
            int value;
            int dis;

            public Pair(int value, int dis) {
                this.value = value;
                this.dis = dis;

            }
        }
    }
}
