package leet_code;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sanyinchen on 20-1-6.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-1-6
 */

class Insert_delete_getrandom_o1_380 {
    class RandomizedSet {
        Set<Integer> hashSet = new HashSet<>();

        /** Initialize your data structure here. */
        public RandomizedSet() {

        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            return hashSet.add(val);
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            return hashSet.remove(val);
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int size = hashSet.size();
            int random = (int) (Math.random() * ((float) size)) % (size);
            Integer[] integers = new Integer[size];
            return hashSet.toArray(integers)[random];
        }
    }
}
