package leet_code;

import java.util.HashSet;
import java.util.Set;

public class Jewels_and_stones_771 {
    public int numJewelsInStones(String J, String S) {
        if (J == null || J.length() == 0 || S == null || S.length() == 0) {
            return 0;
        }
        Set<Character> jSet = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            jSet.add(J.charAt(i));
        }
        int sum = 0;
        for (int i = 0; i < S.length(); i++) {
            if (jSet.contains(S.charAt(i))) {
                sum++;
            }
        }
        return sum;
    }
}
