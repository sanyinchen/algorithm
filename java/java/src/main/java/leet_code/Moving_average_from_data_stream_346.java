package leet_code;

public class Moving_average_from_data_stream_346 {

    class MovingAverage {
        private MyCircularQueue mMyCircularQueue;

        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            mMyCircularQueue = new MyCircularQueue(size);
        }

        public double next(int val) {
            mMyCircularQueue.enQueue(val);
            return ((double) mMyCircularQueue.sum()) / mMyCircularQueue.getSize();
        }


        public class MyCircularQueue {
            private final int[] loopQueue;
            private int head;
            private int size;
            private int maxSize;

            /** Initialize your data structure here. Set the size of the queue to be k. */
            public MyCircularQueue(int k) {
                loopQueue = new int[k];
                head = -1;
                size = 0;
                maxSize = k;
            }

            /** Insert an element into the circular queue. Return true if the operation is successful. */
            public void enQueue(int value) {
                head = (head + 1) % maxSize;
                loopQueue[head] = value;
                size++;
                if (size > maxSize) {
                    size = maxSize;
                }
            }

            public int sum() {
                if (size == 0) {
                    return 0;
                }
                int sum = 0;
                for (int i = 0; i < size; i++) {
                    sum += loopQueue[i];
                }
                return sum;
            }

            public int getSize() {
                return size;
            }
        }
    }
}
