package leet_code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Daily_temperatures_739 {
    static class Solution {
        public int[] dailyTemperatures(int[] t) {
            if (t == null || t.length <= 0) {
                return t;
            }
            List<Pair> pairList = new ArrayList<>();
            for (int i = 0; i < t.length; i++) {
                pairList.add(new Pair(i, t[i]));
            }
            Stack<Pair> stack = new Stack<>();
            for (int i = 0; i < t.length; i++) {
                Pair pair = pairList.get(i);
                if (stack.empty()) {
                    stack.add(pair);
                    continue;
                }
                Pair peek = stack.peek();
                if (pair.value < peek.value) {
                    stack.add(pair);
                    continue;
                }
                while (!stack.isEmpty() && pair.value > stack.peek().value) {
                    Pair tempPeek = stack.peek();
                    tempPeek.diff = pair.key - tempPeek.key;
                    stack.pop();
                }
                stack.add(pair);
            }
            while (!stack.isEmpty()) {
                Pair tempPeek = stack.peek();
                tempPeek.diff = 0;
                stack.pop();
            }
            int[] res = new int[t.length];
            for (int i = 0; i < pairList.size(); i++) {
                res[i] = pairList.get(i).diff;
            }
            return res;
        }

        private class Pair {
            int key;
            int value;
            int diff;

            public Pair(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }

    public static void main(String[] args  ) {
        int[] inputs = new int[]{89,62,70,58,47,47,46,76,100,70};
        int[] res = new Solution().dailyTemperatures(inputs);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

}
