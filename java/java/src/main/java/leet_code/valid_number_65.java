package leet_code;


/**
 * Created by sanyinchen on 19-10-26.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-26
 */

class valid_number_65 {
    static class Solution {
        public boolean isNumber(String s) {
            if (s == null) {
                return false;
            }
            String vStr = s.trim();
            String trimStr = vStr + "";
            if (vStr.endsWith(".") && (vStr.indexOf(".") == vStr.length() - 1)) {
                vStr = vStr.substring(0, vStr.length() - 1);
            }
            System.out.println("vstr:" + vStr);
            String finalVStr = vStr;
            String finalVStr1 = vStr;
            String finalVStr2 = vStr;
            return safeRun(new Runnable() {
                @Override
                public void run() {
                    long l = Long.parseLong(finalVStr);
                    System.out.println("l:" + l);
                }
            }) || safeRun(new Runnable() {
                @Override
                public void run() {
                    int v = Integer.parseInt(finalVStr2);
                    System.out.println("init :" + v);
                }
            }) || safeRun(new Runnable() {
                @Override
                public void run() {
                    float v = Float.parseFloat(finalVStr1);
                    char lastChar = finalVStr1.charAt(finalVStr1.length() - 1);
                    if (lastChar > '9' || lastChar < '0') {
                        throw new RuntimeException("not support");
                    }
                    if (trimStr.endsWith(".") && trimStr.contains("e")) {
                        throw new RuntimeException("not support");
                    }

                }
            });
        }

        private boolean safeRun(Runnable runnable) {
            try {
                runnable.run();
            } catch (Exception e) {
                return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println("==>" + new Solution().isNumber(" 4e3."));
    }
}
