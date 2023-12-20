package leet_code;

public class first_bad_version_278 {

    public class Solution extends VersionControl {

        private int firstBadVersionHelper(int l, int r) {
            if (l >= r) {
                return l;
            }
            int mid = (l + r) >>> 1;
            if (!isBadVersion(mid)) {
                return firstBadVersionHelper(mid + 1, r);
            } else {
                return firstBadVersionHelper(l, mid);
            }
        }

        public int firstBadVersion(int n) {
            return firstBadVersionHelper(1, n);
        }
    }

    boolean isBadVersion(int i) {
        return false;
    }

    class VersionControl {

    }
}
