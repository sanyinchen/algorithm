package leet_code.weekly_contest.weekly_contest_159;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
// todo fail
public class replace_the_substring_for_balanced_string_5232 {
    static class Solution {
        public int balancedString(String s) {
            int q = 0;
            int w = 0;
            int e = 0;
            int r = 0;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'Q') {
                    q++;
                }
                if (s.charAt(i) == 'W') {
                    w++;
                }
                if (s.charAt(i) == 'E') {
                    e++;
                }
                if (s.charAt(i) == 'R') {
                    r++;
                }
            }
            List<Integer> list = new ArrayList<>();
            list.add(q);
            list.add(w);
            list.add(e);
            list.add(r);

//            list.sort(new Comparator<Integer>() {
//                @Override
//                public int compare(Integer o1, Integer o2) {
//                    return o2 - o1;
//                }
//            });
//            int max = list.get(0);

            int sum = 0;
            for (int i = 0; i < list.size(); i++) {
                sum += list.get(i);
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
            int res = 0;
            int item = sum / 4;
            System.out.println("sum:"+sum+" item:"+item);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) < item) {
                    res += (item - list.get(i));
                    System.out.println("i: " + i + " " + (item - list.get(i)));
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        String inputs = "WWEQERQWQWWRWWERQWEQ";

        System.out.println("==>" + new Solution().balancedString(inputs));
    }
}
