package leet_code_part2;

import java.util.ArrayList;
import java.util.List;

public class Greatest_common_divisor_of_strings_1071 {
    class Solution {
        public String gcdOfStrings(String str1, String str2) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < str1.length() && i < str2.length(); i++) {
                if (str1.charAt(i) == str2.charAt(i)) {
                    list.add(str1.substring(0, i + 1));
                }
            }
            if (list.isEmpty()) {
                return "";
            }
            for (int i = list.size() - 1; i >= 0; i--) {
                if (str1.replaceAll(list.get(i), "").length() == 0 && str2.replaceAll(list.get(i), "").length() == 0) {
                    return list.get(i);
                }
            }
            return "";
        }
    }
}
