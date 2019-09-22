package leet_code.weekly_contest.weekly_155;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// todo fail 最大公约数
public class Ugly_number_iii {
    static class Solution {
        private static final int INDEX_MAX = 1000000000;

        //private static final int INDEX_MAX = 100;
        private static final int MAX = 9000;

        public int nthUglyNumber(int n, int a, int b, int c) {
            List<Integer> tabList = new ArrayList<>();
            Set<Integer> visited = new HashSet<>();
            int[] inputs = new int[]{a, b, c};
            Arrays.sort(inputs);
            visited.add(inputs[0]);
            visited.add(inputs[1]);
            visited.add(inputs[2]);
//            for (int i = inputs[0]; i < INDEX_MAX; i++) {
//                if (visited.contains(i)) {
//                    // System.out.println("i===>" + i);
//                    tabList.add(i);
//
//                }
//                for (int j = 0; j < inputs.length && i * inputs[j] <= MAX; j++) {
//                    int temp = i * inputs[j];
//                    // System.out.println(temp);
//                    //           visited.add(temp);
//                    if (i % inputs[j] == 0 || visited.contains(temp)) {
//                        break;
//                    } else {
//                        visited.add(temp);
//                    }
//                }
//
//            }
            for (int i = inputs[0], j = 1; i < INDEX_MAX; j++) {
                if (visited.contains(i)) {
                    continue;
                } else {
                    visited.add(i);
                }
                tabList.add(i);
                i = j * inputs[0];
            }
            for (int i = inputs[1]; i < INDEX_MAX; i *= inputs[1]) {
                if (visited.contains(i)) {
                    continue;
                } else {
                    visited.add(i);
                }
                tabList.add(i);
            }
            for (int i = inputs[2]; i < INDEX_MAX; i *= inputs[2]) {
                if (visited.contains(i)) {
                    continue;
                } else {
                    visited.add(i);
                }
                tabList.add(i);
            }
            tabList.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            return tabList.get(n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().nthUglyNumber(4, 2, 3, 4));
    }
}
