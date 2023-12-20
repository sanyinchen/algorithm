package leet_code;

public class Fixed_point_1064 {

    static class Solution {
        int min = Integer.MAX_VALUE;

        private int fixedPoint(int[] A, int left, int right) {
            if (A == null || left > right) {
                return -1;
            }
            int mid = left + (right - left) / 2;
            if (A[mid] == mid) {
                if (min > mid) {
                    min = mid;
                }
                if (mid > 0 && A[mid - 1] == (mid - 1)) {
                    return fixedPoint(A, left, mid-1);
                }
                // return mid;
            }
            if (A[mid] > mid) {
                return fixedPoint(A, left, mid - 1);
            } else {
                return fixedPoint(A, mid + 1, right);
            }
        }

        public int fixedPoint(int[] A) {
            min = Integer.MAX_VALUE;
            fixedPoint(A, 0, A.length - 1);
            return min == Integer.MAX_VALUE ? -1 : min;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fixedPoint(new int[]{-10, -5, 2, 4, 7, 9}));
    }
}
