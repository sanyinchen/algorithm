package leet_code;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;


/**
 * Created by sanyinchen on 20-1-14.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-1-14
 */

class Decode_string {
    static class Solution {
        public String decodeString(String s) {
            Deque<Character> queue = new LinkedList<Character>();
            for (int i = 0; i < s.length(); i++) {
                char item = s.charAt(i);
                if (item == ']') {
                    StringBuilder temp = new StringBuilder();
                    while (queue.peekLast() != '[') {
                        temp.append(queue.pollLast());
                    }
                    queue.pollLast();
                    StringBuilder numberStr = new StringBuilder();
                    while (!queue.isEmpty() && (queue.peekLast() <= '9' && queue.peekLast() >= '0')) {
                        numberStr.append(queue.pollLast());
                    }
                    numberStr.reverse();
                    temp.reverse();
                    char[] newStrChars = temp.toString().toCharArray();
                    int times = Integer.parseInt(numberStr.toString());
                    for (int ii = 0; ii < times; ii++) {
                        for (int j = 0; j < newStrChars.length; j++) {
                            queue.add(newStrChars[j]);
                        }
                    }
                } else {
                    queue.add(item);
                }
            }

            StringBuilder res = new StringBuilder();
            // System.out.println("queue size:" + queue.size());
            while (!queue.isEmpty()) {
                res.append(queue.poll());
            }
            return res.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.decodeString("10[a2[c]]"));
    }
}
