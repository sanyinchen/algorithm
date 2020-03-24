package leet_code_part2;

import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// todo fail
public class Zigzag_conversion_6 {
    static class Solution {
        public String convert(String s, int numRows) {
            List<char[]> list = new ArrayList<>();
            for (int i = 0; i < s.length(); ) {
                char[] item = new char[numRows];
                if (list.size() % 2 != 0) {
                    System.out.println("" + list.size());
                    item[numRows / 2] = s.charAt(i);
                    i++;
                } else {
                    for (int j = 0; j < numRows; j++) {
                        if (i >= s.length()) {
                            break;
                        }
                        item[j] = s.charAt(i);
                        i++;
                    }
                }
                list.add(item);
            }
            char[][] res = new char[list.size()][];
            res = list.toArray(res);
//            for (int i = 0; i < res.length; i++) {
//                for (int j = 0; j < res[i].length; j++) {
//                    System.out.print(res[i][j] + " ");
//                }
//                System.out.println();
//            }
            String str = "";
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < list.size(); j++) {
                    if (res[j][i] != Character.MIN_VALUE) {
                        str += res[j][i];
                    }
                }
            }
            return str;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convert("PAYPALISHIRING", 4));
    }
}
