package leet_code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Find_anagram_mappings_760 {
    public int[] anagramMappings(int[] A, int[] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0) {
            return new int[]{};
        }
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            map.put(B[i], i);
        }
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            res[i] = map.get(A[i]);
        }

        return res;
    }
}
