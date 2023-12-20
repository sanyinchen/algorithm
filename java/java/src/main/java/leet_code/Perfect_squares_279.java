package leet_code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by sanyinchen on 19-12-19.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-12-19
 */

class Perfect_squares_279 {
    static class Solution {
        private List<Integer> list = new ArrayList<>();

        public int numSquares(int n) {
            list.clear();
            Set<Integer> cache = new HashSet<>();
            for (int i = 1; i <= n && i * i <= n; i++) {
                list.add(i * i);

            }
            int number = 0;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(n);
            cache.add(n);
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    int temp = queue.poll();
                    if (temp == 0) {
                        return number;
                    }
                    for (int i : list) {
                        int tryOffer = temp - i;
                        if (tryOffer >= 0) {
                            if (cache.contains(tryOffer)) {
                                continue;
                            }
                            cache.add(tryOffer);
                            queue.offer(tryOffer);
                        } else {
                            break;
                        }
                    }

                }
                number++;
            }

            return number;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSquares(7168));
    }
}
