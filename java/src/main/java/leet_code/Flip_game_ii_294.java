package leet_code;

// todo fail
public class Flip_game_ii_294 {
    static class Solution {
        private boolean canWinHelper(char[] content, int times, int n, int start) {
            System.out.println("start:" + start + " times:" + times);
            if (start >= content.length) {
                return times % 2 == 1;
            }
            boolean res = false;
            for (int i = 0; i < n - 1; i++) {
                int tempS = i;
                int tempE = i + 1;
                if (content[tempS] == '+' && content[tempE] == '+') {
                    content[tempS] = '-';
                    content[tempE] = '-';
                    res |= canWinHelper(content, times + 1, n, tempE + 1);
                    content[tempS] = '+';
                    content[tempE] = '+';
                }
            }
            return res;
        }

        public boolean canWin(String s) {
            return canWinHelper(s.toCharArray(), 0, s.length(), 0);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canWin("+++++"));
    }
}
