package leet_code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pascals_triangle_ii_119 {
    static class Solution {
        private Map<String, Integer> cache = new HashMap<>();

        private int getPascalsTriangle(int i, int j) {
            if (j == 1 || j == i) {
                return 1;
            }
            String cacheKey = getCacheKey(i, j);
            if (cache.containsKey(cacheKey)) {
                return cache.get(cacheKey);
            }
            int left = getPascalsTriangle(i - 1, j - 1);
            int right = getPascalsTriangle(i - 1, j);
            cache.put(cacheKey, left + right);
            return left + right;
        }

        private String getCacheKey(int i, int j) {
            return i + "_" + j;
        }

        public List<Integer> getRow(int numRows) {
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= numRows+1; i++) {
                list.add(getPascalsTriangle(numRows, i));
            }

            return list;
        }

    }

    public static void main(String[] args) {
        new Solution().getRow(3);
    }
}
