package leet_code.weekly_contest;

/**
 * Created by sanyinchen on 19-9-22.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-22
 */

class Open_the_lock_752 {
    static class Solution {
        private int childIndex = 0;

        private void openLockHelper(int[] childTargets, String target, int start) {

//            if (n == 10) {
//                System.out.println("=======>");
//                return;
//            }
            StringBuilder temp = new StringBuilder();
            // temp.append()
            System.out.println(start + " " + childTargets[childIndex]);
            for (int k = start; k < 4; k++) {
                for (int i = childIndex; i < 9; i++) {
                    childIndex++;
                    openLockHelper(childTargets, target, k);
                }
                childIndex--;
                System.out.println("=======>");
            }

        }

        private void Swap(int chs[], int i, int j) {
            int temp;
            temp = chs[i];
            chs[i] = chs[j];
            chs[j] = temp;
        }

        public int openLock(String[] deadends, String target) {

            int[] childTargets = new int[10];
            for (int i = 0; i <= 9; i++) {
                childTargets[i] = i;
            }
//            for (int k = 0; k < 4; k++) {
//                StringBuilder stringBuilder = new StringBuilder();
//                for (int i = k; i < 9; i++) {
//                    stringBuilder.append(childTargets[i]);
//                    // openLockHelper(childTargets, target, n + 1);
//                }
//
//            }
            openLockHelper(childTargets, target, 0);
            return 0;
        }
    }

    public static void main(String[] args) {
        new Solution().openLock(new String[]{"8888"}, "0009");
    }
}
