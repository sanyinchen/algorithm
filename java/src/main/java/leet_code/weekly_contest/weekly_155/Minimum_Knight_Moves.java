package leet_code.weekly_contest.weekly_155;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by sanyinchen on 19-9-21.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-21
 */

// todo fail
class Minimum_Knight_Moves {
    static class Solution {


        public int minKnightMoves(int x, int y) {

            int step = 0;
            Set<String> visited = new HashSet<>();
            LinkedList<Node> queue = new LinkedList<>();
            queue.add(new Node(0, 0));

            while (queue.size() != 0) {
                Node node = queue.poll();
                String key = node.toString();
                if (x == node.x && y == node.y) {
                    return step;
                }
                if (visited.contains(key)) {
                    continue;
                }
                visited.add(key);
                step++;
                int tempX = node.x;
                int tempY = node.y;
                queue.add(new Node(tempX - 1, tempY - 2));
                queue.add(new Node(tempX - 1, tempY + 2));
                queue.add(new Node(tempX + 1, tempY - 2));
                queue.add(new Node(tempX + 1, tempY + 2));

                queue.add(new Node(tempX - 2, tempY - 1));
                queue.add(new Node(tempX - 2, tempY + 1));
                queue.add(new Node(tempX + 2, tempY - 1));
                queue.add(new Node(tempX + 2, tempY + 1));

            }
            return step;
        }

        public class Node {
            int x;
            int y;

            public Node(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public String toString() {
                return x + "_" + y;
            }
        }
    }

    public static void main(String[] args) {
        System.out.print(new Solution().minKnightMoves(5, 5));
    }
}
