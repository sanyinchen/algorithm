package leet_code.weekly_contest.weekly_155;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by sanyinchen on 19-9-21.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-21
 */

class Minimum_Knight_Moves {
    static class Solution {

        private int getHWight(int x, int y, int targetX, int targetY) {
            if (Math.abs(targetX - x) <= 70 || Math.abs(targetY - y) <= 70) {
                return 0;
            }
            return Math.abs(targetX - x) + Math.abs(targetY - y);
        }

        public int minKnightMoves(int x, int y) {

            int step = 0;
            int[][] steps = new int[][]{{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
            Set<Integer> visited = new HashSet<>();
            LinkedList<Node> queue = new LinkedList<>();
            queue.add(new Node(0, 0));

            while (queue.size() != 0) {
                int size = queue.size();
                step++;
                while (size-- > 0) {
                    Node node = queue.poll();

                    if (x == node.x && y == node.y) {
                        return step - 1;
                    }
                    if (visited.contains(node.x * 1000 + node.y)) {
                        continue;
                    }
                    visited.add(node.x * 1000 + node.y);

                    int tempX = node.x;
                    int tempY = node.y;


                    Node[] tempNodes = new Node[8];

                    int minWeight = Integer.MAX_VALUE;
                    for (int i = 0; i < steps.length; i++) {
                        int[] v = steps[i];
                        Node temp = new Node(tempX + v[0], tempY + v[1], step + getHWight(tempX + v[0], tempY + v[1], x,
                                y));
                        tempNodes[i] = temp;
                        if (minWeight > temp.weight) {
                            minWeight = temp.weight;
                        }
                    }


                    for (Node item : tempNodes) {
                        if (item.weight == minWeight) {
                            queue.add(item);
                        }
                    }

                }

            }

            return step - 1;
        }

        public class Node {
            int x;
            int y;
            int weight;

            public Node(int x, int y) {
                this.x = x;
                this.y = y;
            }

            public Node(int x, int y, int weight) {
                this.x = x;
                this.y = y;
                this.weight = weight;
            }

            @Override
            public String toString() {
                return x + "_" + y;
            }
        }
    }

    public static void main(String[] args) {
        System.out.print(new Solution().minKnightMoves(300, 0));
    }
}
