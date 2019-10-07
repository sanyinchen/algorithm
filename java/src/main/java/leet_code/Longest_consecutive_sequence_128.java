package leet_code;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Longest_consecutive_sequence_128 {
    static class Solution {
        public int longestConsecutive(int[] nums) {
            Map<Integer, Integer> cache = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (!cache.containsKey(nums[i])) {
                    cache.put(nums[i], i);
                }
            }
            WeightedQuickUnionUF weightedQuickUnionUF = new WeightedQuickUnionUF(nums.length);

            for (Map.Entry<Integer, Integer> item : cache.entrySet()) {
                int temp = item.getKey();
                if (cache.containsKey(temp + 1)) {
                    weightedQuickUnionUF.union(item.getValue(), cache.get(temp + 1));
                }
            }

            return weightedQuickUnionUF.maxDep();
        }

        public class WeightedQuickUnionUF {
            private int[] parent;   // parent[i] = parent of i
            private int[] size;     // size[i] = number of sites in subtree rooted at i
            private int count;      // number of components

            public WeightedQuickUnionUF(int n) {
                count = n;
                parent = new int[n];
                size = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                    size[i] = 1;
                }
            }

            public int count() {
                return count;
            }

            public int find(int p) {
                validate(p);
                while (p != parent[p])
                    p = parent[p];
                return p;
            }

            // validate that p is a valid index
            private void validate(int p) {
                int n = parent.length;
                if (p < 0 || p >= n) {
                    throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
                }
            }

            public boolean connected(int p, int q) {
                return find(p) == find(q);
            }

            public void union(int p, int q) {
                int rootP = find(p);
                int rootQ = find(q);
                if (rootP == rootQ) return;

                // make smaller root point to larger one
                if (size[rootP] < size[rootQ]) {
                    parent[rootP] = rootQ;
                    size[rootQ] += size[rootP];
                } else {
                    parent[rootQ] = rootP;
                    size[rootP] += size[rootQ];
                }
                count--;
            }

            public int maxDep() {
                int max = Integer.MIN_VALUE;
                for (int i = 0; i < size.length; i++) {
                    if (max < size[i]) {
                        max = size[i];
                    }
                }
                return max == Integer.MIN_VALUE ? 0 : max;
            }
        }
    }

    public static void main(String[] args) {
        int[] inputs = new int[]{0, 0, -1};
        System.out.println("==>" + new Solution().longestConsecutive(inputs));
    }

}
