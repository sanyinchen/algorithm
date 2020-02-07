package leet_code;

public class Flip_game_ii_294 {
    static class Solution {
        public boolean canWin(String content) {
            for (int i = 1; i < content.length(); i++) {
                if (content.charAt(i - 1) == '+' && content.charAt(i) == '+') {
                    if (!canWin(content.substring(0, i - 1) + "--" + content.substring(i + 1))) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canWin("+++++"));
    }
}
