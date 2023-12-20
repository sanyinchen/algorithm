package leet_code;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sanyinchen on 20-1-14.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-1-14
 */

class Flood_fill_733 {
    class Solution {

        Set<String> cache = new HashSet<>();

        private String getKey(int sr, int sc) {
            return sr + "_" + sc;
        }

        private int getColor(int[][] image, int sr, int sc) {
            if (sr >= image.length || sr < 0 || sc >= image[0].length || sc < 0) {
                return Integer.MAX_VALUE;
            }
            return image[sr][sc];
        }

        private void dfs(int[][] image, int sr, int sc, int newColor, int color) {
            if (sr >= image.length || sr < 0 || sc >= image[0].length || sc < 0) {
                return;
            }
            String key = getKey(sr, sc);
            if (cache.contains(key)) {
                return;
            }
            image[sr][sc] = newColor;
            cache.add(getKey(sr, sc));
            if (getColor(image, sr + 1, sc) == color) {
                dfs(image, sr + 1, sc, newColor, color);
            }
            if (getColor(image, sr - 1, sc) == color) {
                dfs(image, sr - 1, sc, newColor, color);
            }
            if (getColor(image, sr, sc + 1) == color) {
                dfs(image, sr, sc + 1, newColor, color);
            }
            if (getColor(image, sr, sc - 1) == color) {
                dfs(image, sr, sc - 1, newColor, color);
            }
        }

        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            dfs(image, sr, sc, newColor, image[sr][sc]);
            return image;
        }
    }
}
