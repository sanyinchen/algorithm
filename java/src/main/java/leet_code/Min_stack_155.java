package leet_code;

import java.util.Stack;

/**
 * Created by sanyinchen on 19-10-25.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-25
 */

class Min_stack_155 {
    class MinStack {

        private Stack<Integer> mStack;
        private int min;

        /** initialize your data structure here. */
        public MinStack() {
            min = Integer.MAX_VALUE;
            mStack = new Stack<>();
        }

        private void updateMin() {
            Stack<Integer> copy = (Stack<Integer>) mStack.clone();
            min = Integer.MAX_VALUE;
            while (!copy.isEmpty()) {
                int temp = copy.pop();
                System.out.println("temp:" + temp);
                if (min < temp) {
                    min = temp;
                }
            }
        }

        public void push(int x) {
            mStack.push(x);
            updateMin();
        }

        public void pop() {
            mStack.pop();
        }

        public int top() {
            return mStack.peek();
        }

        public int getMin() {
            return min;
        }
    }
}
