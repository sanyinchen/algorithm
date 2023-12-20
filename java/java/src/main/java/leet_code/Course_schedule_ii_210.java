package leet_code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by sanyinchen on 19-10-23.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-23
 */

class Course_schedule_ii_210 {
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            Map<Integer, Set<Integer>> graph = new HashMap<>();
            int[] inDegree = new int[numCourses];
            boolean[] mark = new boolean[numCourses];

            for (int i = 0; i < numCourses; i++) {
                graph.put(i, new HashSet<>());
            }
            for (int i = 0; i < prerequisites.length; i++) {
                int first = prerequisites[i][0];
                int second = prerequisites[i][1];
                graph.get(second).add(first);
                inDegree[first]++;
            }
            int count = 0;
            int[] order = new int[numCourses];
            for (int zeroInDegreeIndex = 0; zeroInDegreeIndex < graph.size(); zeroInDegreeIndex++) {
                if (mark[zeroInDegreeIndex] || inDegree[zeroInDegreeIndex] != 0) {
                    continue;
                }


                Queue<Integer> queue = new LinkedList<>();
                queue.add(zeroInDegreeIndex);

                while (!queue.isEmpty()) {
                    int v = queue.poll();
                    order[count++] = v;
                    mark[v] = true;
                    for (int item : graph.get(v)) {
                        if (mark[item]) {
                            return new int[]{};
                        }
                        inDegree[item]--;
                        if (inDegree[item] == 0) {
                            queue.add(item);
                        }
                    }
                }
            }
            return count == graph.size() ? order : new int[]{};
        }
    }
}
