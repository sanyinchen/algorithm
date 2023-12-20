package leet_code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// todo fail
public class Circular_permutation_in_binary_representation_5239 {
    static class Solution {
        private boolean isValid(int x, int y) {

            int temp = x ^ y;

            if (temp == 0) {
                return false;
            }
            int count = 0;
            while (temp != 0) {
                count++;
                if (count > 1) {
                    return false;
                }
                temp &= (temp - 1);
            }
            return count == 1;
        }

        public List<Integer> circularPermutation(int n, int start) {
            int max = (2 << (n - 1)) - 1;
            Queue<Integer> cache = new LinkedList<>();
            for (int i = 0; i <= max; i++) {
                cache.add(i);
            }

            List<Integer> temp = new ArrayList<>();

            int item = start;
            while (!cache.isEmpty()) {
                temp.add(item);
                cache.remove(item);
                System.out.println("==>" + item + " " + cache.size());
                for (int i : cache) {
                    if (isValid(item, i)) {
                        item = i;
                        break;
                    }
                }
            }
            List<Integer> res = new ArrayList<>();
            res.addAll(temp);

            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        int start = 2;
        for (int item : solution.circularPermutation(n, start)) {
            System.out.println(item);
        }
    }
}
