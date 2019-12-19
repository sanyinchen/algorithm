package leet_code.weekly_contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by sanyinchen on 19-9-22.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-22
 */

class Open_the_lock_752 {
    static class Solution {
        Set<String> cache = new HashSet<>();

        private String getLockStr(Integer[] locks) {
            StringBuilder str = new StringBuilder();
            for (int item : locks) {
                str.append(item);
            }
            return str.toString();
        }

        private List<Integer[]> nextLockList(Integer[] locks) {
            List<Integer[]> tempList = new ArrayList<>();
            for (int i = 0; i < locks.length; i++) {
                Integer[] newLock = new Integer[locks.length];
                System.arraycopy(locks, 0, newLock, 0, locks.length);
                Integer[] newLock2 = new Integer[locks.length];
                System.arraycopy(locks, 0, newLock2, 0, locks.length);
                newLock[i] = (newLock[i] + 1 + 10) % 10;
                newLock2[i] = (newLock2[i] - 1 + 10) % 10;
                String lockStr = getLockStr(newLock);
                if (!cache.contains(lockStr)) {
                    tempList.add(newLock);
                    cache.add(lockStr);
                }

                String lockStr2 = getLockStr(newLock2);
                if (!cache.contains(lockStr2)) {
                    tempList.add(newLock2);
                    cache.add(lockStr2);
                }
            }
            return tempList;
        }

        public int openLock(String[] deadends, String target) {
            int number = 0;
            cache.clear();
            Set<String> deadendsSet = new HashSet<>(Arrays.asList(deadends));

            Integer[] initlock = new Integer[]{0, 0, 0, 0};
            LinkedList<Integer[]> queue = new LinkedList<>();
            queue.add(initlock);
            cache.add("0000");
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    Integer[] itemLock = queue.poll();
                    String lockRank = getLockStr(itemLock);
                    if (deadendsSet.contains(lockRank)) {
                        continue;
                    }
                    if (target.equals(lockRank)) {
                        return number;
                    }
                    queue.addAll(nextLockList(itemLock));
                }
                number++;
            }

            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println("==>" + new Solution().openLock(new String[]{"8888"}, "0009"));
    }
}
