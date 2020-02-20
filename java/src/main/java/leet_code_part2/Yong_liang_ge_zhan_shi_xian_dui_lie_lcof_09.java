package leet_code_part2;

import java.util.Stack;

public class Yong_liang_ge_zhan_shi_xian_dui_lie_lcof_09 {
    class CQueue {
        Stack<Integer> topStack = new Stack<>();
        Stack<Integer> contentStack = new Stack<>();

        public CQueue() {

        }

        public void appendTail(int value) {
            if (topStack.isEmpty()) {
                topStack.push(value);
            } else {
                contentStack.push(value);
            }
        }

        public int deleteHead() {
            if (topStack.isEmpty()) {
                return -1;
            }
            try {
                return topStack.pop();
            } finally {
                if (!contentStack.isEmpty()) {
                    while (contentStack.size() > 1) {
                        topStack.push(contentStack.pop());
                    }
                    int top = contentStack.pop();
                    while (!topStack.isEmpty()) {
                        contentStack.push(topStack.pop());
                    }
                    topStack.push(top);
                }
            }
        }
    }
}
