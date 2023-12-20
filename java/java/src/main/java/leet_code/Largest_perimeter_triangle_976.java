package leet_code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by sanyinchen on 19-10-10.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-10
 */

class Largest_perimeter_triangle_976 {
    class Solution {
        int max = Integer.MIN_VALUE;
        Map<Integer, Integer> marked = new HashMap<>();

        private int find(int[] edges, int n) {
            if (n < 0) {
                return Integer.MIN_VALUE;
            }
            if (marked.containsKey(n)) {
                return marked.get(n);
            }
            int a = edges[n];
            int b = find(edges, n - 1);
            int c = find(edges, n - 2);

            if (a != Integer.MIN_VALUE && b != Integer.MIN_VALUE && c != Integer.MIN_VALUE && (b + c) > a) {
                max = Math.max(max, (a + b + c));
            }

            marked.put(n, a);
            return a;
        }

        public int largestPerimeter(int[] inputs) {
            if (inputs.length < 3) {
                return 0;
            }
            max = Integer.MIN_VALUE;
            Arrays.sort(inputs);
            find(inputs, inputs.length - 1);
            return max == Integer.MIN_VALUE ? 0 : max;
        }
    }

}
