package leet_code;

import java.util.ArrayList;
import java.util.List;

public class Find_positive_integer_solution_for_a_given_equation_5238 {
    class Solution {
        private int MAX = 1000;

        public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 1; i < MAX; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 1; j < MAX; j++) {
                    if (customfunction.f(i, j) == z) {
                        temp.add(i);
                        temp.add(j);
                    }
                }
                if (!temp.isEmpty()) {
                    res.add(temp);
                }
            }
            return res;
        }
    }

    interface CustomFunction {

        // Returns positive integer f(x, y) for any given positive integer x and y.
        int f(int x, int y);
    }

    ;
}
