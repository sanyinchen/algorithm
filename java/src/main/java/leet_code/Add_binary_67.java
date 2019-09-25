package leet_code;

import java.math.BigInteger;

/**
 * Created by sanyinchen on 19-9-25.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-25
 */

class Add_binary_67 {
    static class Solution {

        private String addBinaryHelper(int[] a, int[] b, int i, String str, int preStep) {
            if (i >= a.length && i >= b.length && preStep == 0) {
                return str;
            }

            int temp = preStep;
            if (i < a.length) {
                temp += a[i];
            }
            if (i < b.length) {
                temp += b[i];
            }
            System.out.println("i:" + i + " preStep:" + preStep + " str:" + str + " temp:" + temp);
            return addBinaryHelper(a, b, i + 1, temp % 2 + str, temp / 2);
        }

        public String addBinary(String a, String b) {
            int[] aInt = new int[a.length()];
            int[] bInt = new int[b.length()];
            for (int i = a.length() - 1, j = 0; i >= 0; i--, j++) {
                aInt[j] = Integer.parseInt(a.charAt(i) + "");
            }
            for (int i = b.length() - 1, j = 0; i >= 0; i--, j++) {
                bInt[j] = Integer.parseInt(b.charAt(i) + "");
            }
            return addBinaryHelper(aInt, bInt, 0, "", 0);

        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("1010", "1011"));
    }
}
