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

class K_closest_points_to_origin_973 {
    class Solution {
        PriorityQueue<Point> mPriorityQueue = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o2.distance() - o1.distance();
            }
        });

        public int[][] kClosest(int[][] points, int K) {
            for (int i = 0; i < points.length; i++) {
                Point point = new Point(points[i][0], points[i][1]);
                mPriorityQueue.add(point);
                if (mPriorityQueue.size() > K) {
                    mPriorityQueue.poll();
                }
            }
            int[][] res = new int[mPriorityQueue.size()][2];
            int i = 0;
            while (!mPriorityQueue.isEmpty()) {
                Point point = mPriorityQueue.poll();
                res[i][0] = point.x;
                res[i++][0] = point.y;
            }
            return res;
        }

        private class Point {
            int x;
            int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            public int distance() {
                return x * x + y * y;
            }
        }
    }
}
