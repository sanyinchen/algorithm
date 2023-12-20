package leet_code;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sanyinchen on 19-10-25.
 * 素数打表
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-25
 */

class Count_primes_204 {
    public static Set<Integer> visited = new HashSet<>();

    static {
        int n = 1500000;
        for (int i = 2; i * i < n; i++) {
            if (!visited.contains(i)) {
                for (int j = i * i; j < n; j += i) {
                    visited.add(j);
                }
            }
        }
    }

    public int countPrimes(int n) {

        int sum = 0;
        for (int i = 2; i < n; i++) {
            if (!visited.contains(i)) {
                sum++;
            }
        }
        return sum;
    }
}
