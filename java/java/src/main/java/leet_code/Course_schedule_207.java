package leet_code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Course_schedule_207 {
    static class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {

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

            for (int zeroInDegreeIndex = 0; zeroInDegreeIndex < graph.size(); zeroInDegreeIndex++) {
                if (mark[zeroInDegreeIndex] || inDegree[zeroInDegreeIndex] != 0) {
                    continue;
                }


                Queue<Integer> queue = new LinkedList<>();
                queue.add(zeroInDegreeIndex);

                while (!queue.isEmpty()) {
                    int v = queue.poll();
                    count++;
                    mark[v] = true;
                    for (int item : graph.get(v)) {
                        if (mark[item]) {
                            return false;
                        }
                        inDegree[item]--;
                        if (inDegree[item] == 0) {
                            queue.add(item);
                        }
                    }
                }
            }
            return count == graph.size();
        }

    }

    public static void main(String[] args) {
        int[][] inputs = new int[][]{{1, 0}};
        System.out.println("==>" + new Solution().canFinish(2, inputs));
    }
}
