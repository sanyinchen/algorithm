package leet_code;

/**
 * Created by sanyinchen on 19-10-15.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-15
 */

class Redundant_connection_684 {
    class Solution {
        private int[] height;
        private int[] ids;

        private boolean union_set(int x, int y) {
            int xa = union_find(x);
            int ya = union_find(y);
            if (xa == ya) {
                return false;
            }
            if (height[x] == height[y]) {
                height[x]++;
                ids[ya] = xa;
                return true;
            }
            if (height[x] < height[y]) {
                ids[xa] = ya;
            } else {
                ids[ya] = xa;
            }
            return true;
        }

        private int union_find(int x) {
            if (x >= ids.length) {
                return -1;
            }
            if (x != ids[x]) {
                ids[x] = union_find(ids[x]);
            }
            return ids[x];
        }

        public int[] findRedundantConnection(int[][] edges) {
            height = new int[edges.length + 1];
            ids = new int[edges.length + 1];
            for (int i = 0; i <= edges.length; i++) {
                ids[i] = i;
            }
            for (int i = 0; i < edges.length; i++) {
                int[] temp = edges[i];
                if (!union_set(temp[0], temp[1])) {
                    return temp;
                }
            }

            return null;
        }
    }
}
