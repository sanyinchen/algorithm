package leet_code;

/**
 * from https://leetcode-cn.com/problems/design-circular-queue/
 */
public class Design_circular_queue_622 {
    static class MyCircularQueue {
        private final int[] loopQueue;
        private int tail;
        private int head;
        private int size;
        private int maxSize;

        /** Initialize your data structure here. Set the size of the queue to be k. */
        public MyCircularQueue(int k) {
            loopQueue = new int[k];
            tail = -1;
            head = -1;
            size = 0;
            maxSize = k;
        }

        /** Insert an element into the circular queue. Return true if the operation is successful. */
        public boolean enQueue(int value) {
            if (size >= maxSize) {
                return false;
            }

            head = (head + 1) % maxSize;
            loopQueue[head] = value;
            if (size == 0) {
                tail = head;
            }
            size++;

            return true;
        }

        /** Delete an element from the circular queue. Return true if the operation is successful. */
        public boolean deQueue() {
            if (size == 0) {
                return false;
            }
            tail = (tail + 1) % maxSize;
            size--;
            if (size == 0) {
                tail = head;
            }
            return true;
        }

        /** Get the front item from the queue. */
        public int Front() {
            if (size == 0) {
                return -1;
            }

            return loopQueue[tail];
        }

        /** Get the last item from the queue. */
        public int Rear() {
            if (size == 0) {
                return -1;
            }
            return loopQueue[head];
        }

        /** Checks whether the circular queue is empty or not. */
        public boolean isEmpty() {
            return size == 0;
        }

        /** Checks whether the circular queue is full or not. */
        public boolean isFull() {
            return size == maxSize;
        }
    }

    public static void main(String[] args) {

        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
        System.out.println(circularQueue.enQueue(2) + " true");
        System.out.println(circularQueue.Rear() + " 0");
        System.out.println(circularQueue.Front() + " 0");

//        MyCircularQueue circularQueue = new MyCircularQueue(8); // 设置长度为 3
//
//        System.out.println(circularQueue.enQueue(3) + " true"); // 返回 true
//
//        System.out.println(circularQueue.enQueue(9) + " true"); // 返回 true
//
//        System.out.println(circularQueue.enQueue(5) + " true"); // 返回 true
//
//        System.out.println(circularQueue.enQueue(0) + " false"); // 返回 false，队列已满
//
//        System.out.println(circularQueue.deQueue() + " 3"); // 返回 3
//        System.out.println(circularQueue.deQueue() + " 3"); // 返回 3
//        System.out.println(circularQueue.isEmpty() + " true"); // 返回 true
//
//        System.out.println(circularQueue.isEmpty() + " true"); // 返回 true
//
//        System.out.println(circularQueue.Rear() + " 0"); // 返回 4
//        System.out.println(circularQueue.Rear() + " 0"); // 返回 4
//
//        System.out.println(circularQueue.deQueue() + " 4"); // 返回 4
//


//        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
//
//        System.out.println(circularQueue.enQueue(1) + " true"); // 返回 true
//
//        System.out.println(circularQueue.enQueue(2) + " true"); // 返回 true
//
//        System.out.println(circularQueue.enQueue(3) + " true"); // 返回 true
//
//        System.out.println(circularQueue.enQueue(4) + " false"); // 返回 false，队列已满
//
//        System.out.println(circularQueue.Rear() + " 3"); // 返回 3
//
//        System.out.println(circularQueue.isFull() + " true"); // 返回 true
//
//        System.out.println(circularQueue.deQueue() + " true"); // 返回 true
//
//        System.out.println(circularQueue.enQueue(4) + " true"); // 返回 true
//
//        System.out.println(circularQueue.Rear() + " 4"); // 返回 4
//

    }
}
