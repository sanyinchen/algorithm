package leet_code;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanyinchen on 19-10-12.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-12
 */

class Reverse_words_in_a_string_151 {
    static class Solution {
        public String reverseWords(String s) {
            String[] strs = s.split(" ");
            String str = "";
            List<String> container = new ArrayList<>();
            for (int i = strs.length - 1; i >= 0; i--) {
                String temp = strs[i].replaceAll(" ", "");
                if (temp.length() == 0) {
                    continue;
                }
                container.add(temp);
            }
            for (int i = 0; i < container.size(); i++) {
                str += container.get(i);
                if (i != container.size() - 1) {
                    str += " ";
                }
            }
            return str;
        }
    }

    public static void main(String[] args) {
        System.out.println("==>" + (new Solution().reverseWords("  hello world!  ") + "end"));
    }
}
