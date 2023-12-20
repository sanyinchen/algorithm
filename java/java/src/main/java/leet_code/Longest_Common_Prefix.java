package leet_code;

public class Longest_Common_Prefix {

    class Solution {
        public String longestCommonPrefix(String[] strs) {
            StringBuilder res = new StringBuilder();
            if (strs == null || strs.length == 0) {
                return res.toString();
            }
            int i = 0;
            char prex = '\0';
            int allScan = 0;
            int stsNumber = strs.length;
            while (true) {
                for (String str : strs) {
                    if (i >= str.length()) {
                        return res.toString();
                    }
                    char tempPrex = str.charAt(i);
                    if (prex == '\0') {
                        prex = tempPrex;
                    }
                    if (tempPrex != prex) {
                        return res.toString();
                    }
                    allScan++;
                    if (allScan == stsNumber) {
                        allScan = 0;
                        i++;
                        res.append(tempPrex);
                        prex = '\0';
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
