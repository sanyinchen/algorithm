package leet_code;

public class Apply_basic_algorithm_thinking_959 {
    class Solution {
        int[] maxHeap;


        private void swim(int i) {
            while (i > 0) {
                int rootIndex = i / 2;
                if (maxHeap[i] < maxHeap[rootIndex]) {
                    swap(i, rootIndex);
                    i = rootIndex;
                } else {
                    break;
                }
            }

        }

        private void sink(int i, int len) {
            while (i < len) {
                int rootIndex = i / 2;
                if (maxHeap[rootIndex] > maxHeap[i]) {
                    swap(rootIndex, i);
                    i++;
                } else {
                    break;
                }

            }
        }

        private void swap(int i, int j) {
            int temp = maxHeap[i];
            maxHeap[i] = maxHeap[j];
            maxHeap[j] = temp;
        }

        public int findKthLargest(int[] nums, int k) {
            maxHeap = new int[k + 1];

            return maxHeap[k];
        }
    }
}
