package leet_code.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Nim_game_292 {
    static class Solution {
        public boolean canWinNim(int n) {
            return n % 4 != 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.print(solution.canWinNim(8));
    }
}
