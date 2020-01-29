package leet_code;

public class Guess_number_higher_or_lower_347 {
    public static class GuessGame {
        int guess(int num) {
            if (num == 6) {
                return 0;
            }
            if (num < 6) {
                return 1;
            }
            return -1;
        }
    }

    public static class Solution extends GuessGame {
        private int search(int l, int r) {
            System.out.println("l:"+l+" r:"+r);
            if (l > r) {
                return -1;
            }
            int mid = (l + r) >>> 1;
            if (guess(mid) == 0) {
                return mid;
            }
            if (guess(mid) > 0) {
                return search(mid + 1, r);
            } else {
                return search(l, mid - 1);
            }
        }

        public int guessNumber(int n) {
            return search(1, n);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.guessNumber(10));
    }
}
