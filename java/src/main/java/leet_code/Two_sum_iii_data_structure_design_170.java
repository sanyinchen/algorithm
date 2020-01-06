package leet_code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by sanyinchen on 20-1-6.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-1-6
 */

class Two_sum_iii_data_structure_design_170 {
    static class TwoSum {
        Map<Integer, Integer> cache;

        /** Initialize your data structure here. */
        public TwoSum() {
            cache = new HashMap<>();
        }

        /** Add the number to an internal data structure.. */
        public void add(int number) {
            if (!cache.containsKey(number)) {
                cache.put(number, 1);
            } else {
                cache.replace(number, cache.get(number) + 1);
            }
        }

        /** Find if there exists any pair of numbers which sum is equal to the value. */
        public boolean find(int value) {
            for (Map.Entry<Integer, Integer> item : cache.entrySet()) {
                int require = value - item.getKey();
                if (cache.containsKey(require)) {
                    if (item.getKey() == require) {
                        if (cache.get(require) > 1) {
                            return true;
                        } else {
                            continue;
                        }

                    }
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        twoSum.add(3);
        twoSum.add(2);
        twoSum.add(1);
        System.out.println(twoSum.find(6));
    }

}
