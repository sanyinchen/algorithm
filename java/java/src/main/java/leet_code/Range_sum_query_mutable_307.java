package leet_code;

/**
 * Created by sanyinchen on 19-10-24.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-24
 */

class Range_sum_query_mutable_307 {
    class NumArray {
        private int[] tree;
        private int n;
        private int[] numsCopy;

        private int lowBit(int x) {
            return x & (-x);
        }

        public NumArray(int[] nums) {
            tree = new int[nums.length + 1];
            numsCopy = new int[nums.length + 1];
            n = nums.length;
            for (int i = 0; i < n; i++) {
                update(i, nums[i]);
            }
        }

        private void modify(int i, int val) {
            i++;
            while (i <= n) {
                tree[i] += val;
                i += lowBit(i);
            }
        }

        public void update(int i, int val) {
            modify(i, val - numsCopy[i]);
            numsCopy[i] = val;
        }

        public int sumRange(int x) {
            int sum = 0;
            x++;
            while (x > 0) {
                sum += tree[x];
                x -= lowBit(x);
            }
            return sum;
        }

        public int sumRange(int i, int j) {
            if (i <= j) {
                return sumRange(j) - sumRange(i - 1);
            } else {
                return sumRange(i) - sumRange(j - 1);
            }
        }
    }

}
