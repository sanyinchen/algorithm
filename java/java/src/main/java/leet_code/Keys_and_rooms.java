package leet_code;

import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by sanyinchen on 20-1-15.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-1-15
 */

class Keys_and_rooms {
    class Solution {
        int nodeNumber = 0;
        Set<Integer> cache = new HashSet<>();

        private void dfs(List<List<Integer>> rooms, int i) {
            cache.add(i);
            nodeNumber++;
            for (int child : rooms.get(i)) {
                if (!cache.contains(child)) {
                    dfs(rooms, child);
                }
            }
        }

        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            dfs(rooms, 0);
            return nodeNumber == rooms.size();
        }
    }
}
