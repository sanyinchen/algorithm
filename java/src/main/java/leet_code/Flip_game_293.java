package leet_code;

import java.util.ArrayList;
import java.util.List;

public class Flip_game_293 {
    class Solution {
        private char[] createNewStrArrays(String str) {
            return str.toCharArray();
        }

        private String createStr(char[] arrays) {
            String str = "";
            for (char item : arrays) {
                str += item;
            }
            return str;
        }

        public List<String> generatePossibleNextMoves(String str) {
            List<String> res = new ArrayList<>();
            for (int i = 0; i < str.length(); i++) {
                int start = i;
                int end = start + 1;
                if (end >= str.length()) {
                    continue;
                }
                char[] arrays = createNewStrArrays(str);
                if (arrays[start] != '+' || arrays[end] != '+') {
                    continue;
                }
                arrays[start] = '-';
                arrays[end] = '-';
                res.add(createStr(arrays));
            }
            return res;
        }
    }
}
