package leet_code_part2;

import edu.princeton.cs.algs4.Queue;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Dui_lie_de_zui_da_zhi_lcof_59 {
    class MaxQueue {
        private LinkedList<Integer> queue = new LinkedList<>();
        private PriorityQueue<Integer> maxQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        public MaxQueue() {

        }

        public int max_value() {
            if (maxQueue.isEmpty()) {
                return -1;
            }
            return maxQueue.peek();
        }

        public void push_back(int value) {
            queue.add(value);
            maxQueue.add(value);
        }

        public int pop_front() {
            if (queue.isEmpty()) {
                return -1;
            }
            int remove = queue.poll();
            maxQueue.remove(remove);
            return remove;
        }
    }
}
