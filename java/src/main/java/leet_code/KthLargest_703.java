package leet_code;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by sanyinchen on 20-1-18.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-1-18
 */

class KthLargest_703 {
    class KthLargest {
        PriorityQueue<Integer> mPriorityQueue;
        int mCapacity;

        public KthLargest(int k, int[] nums) {
            mCapacity = k;
            mPriorityQueue = new PriorityQueue<>(k, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            for (int i = 0; i < nums.length; i++) {
                add(nums[i]);
            }
        }

        public int add(int val) {
            mPriorityQueue.add(val);
            if (mPriorityQueue.size() > mCapacity) {
                mPriorityQueue.poll();
            }

            return mPriorityQueue.peek();
        }
    }
}
