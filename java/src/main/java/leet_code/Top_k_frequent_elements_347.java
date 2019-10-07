package leet_code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by sanyinchen on 19-10-7.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-7
 */

class Top_k_frequent_elements_347 {
    class Solution {
        public List<Integer> topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> cache = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (!cache.containsKey(nums[i])) {
                    cache.put(nums[i], 1);
                } else {
                    int count = cache.get(nums[i]) + 1;
                    cache.replace(nums[i], count);
                }
            }
            Iterator<Integer> iterator = cache.keySet().iterator();
            PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    return o2.count - o1.count;
                }
            });
            while (iterator.hasNext()) {
                int key = iterator.next();
                Pair pair = new Pair(key, cache.get(key));
                priorityQueue.add(pair);
            }
            List<Integer> res = new ArrayList<>();
            int tempK = k;
            while (!priorityQueue.isEmpty() && tempK != 0) {
                res.add(priorityQueue.poll().value);
                tempK--;
            }
            return res;
        }

        private class Pair {
            int value;
            int count;

            public Pair(int value, int count) {
                this.value = value;
                this.count = count;
            }
        }
    }
}
