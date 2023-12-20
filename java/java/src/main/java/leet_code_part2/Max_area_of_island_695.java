package leet_code_part2;

// todo fail
public class Max_area_of_island_695 {
    class Solution {
        private int[] parent;   // parent[i] = parent of i
        private int[] size;     // size[i] = number of sites in subtree rooted at i

        public int maxAreaOfIsland(int[][] grid) {
            if (grid.length == 0) {
                return 0;
            }
            int n = Math.max(grid.length, grid[0].length);
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        union(i, j);
                    }
                }
            }
            int max = 0;
            for (int i = 0; i < n; i++) {
                max = Math.max(size[i], max);
            }
            return max;
        }

        public int find(int p) {
            while (p != parent[p])
                p = parent[p];
            return p;
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
        }
    }
}
