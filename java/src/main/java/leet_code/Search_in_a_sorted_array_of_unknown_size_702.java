package leet_code;

public class Search_in_a_sorted_array_of_unknown_size_702 {
    /**
     * just mock
     */
    public class ArrayReader {
        public int get(int k) {
            return 0;
        }
    }

    class Solution {

        private int getBound(int high, ArrayReader reader) {
            if (reader.get(high) == Integer.MAX_VALUE) {
                return high;
            }
            return getBound(high * 2, reader);
        }

        private int binarySearch(ArrayReader reader, int target, int l, int r) {
            if (l > r) {
                return -1;
            }
            int mid = (l + r) >>> 1;
            if (reader.get(mid) == target) {
                return mid;
            }
            if (reader.get(mid) == Integer.MAX_VALUE || reader.get(mid) > target) {
                return binarySearch(reader, target, l, mid - 1);
            } else {
                return binarySearch(reader, target, mid + 1, r);
            }
        }

        public int search(ArrayReader reader, int target) {
            int max = getBound(1, reader);
            int min = 0;
            return binarySearch(reader, target, min, max);
        }
    }
}
