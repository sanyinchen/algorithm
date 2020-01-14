package leet_code;

import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.Stack;

/**
 * Created by sanyinchen on 20-1-14.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-1-14
 */

class Implement_queue_using_stacks {
    class MyQueue {
        Stack<Integer> mStack = new Stack<>();

        /** Initialize your data structure here. */
        public MyQueue() {

        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            List<Integer> list = new ArrayList<>();
            while (!mStack.isEmpty()) {
                list.add(mStack.pop());
            }
            list.add(x);
            mStack = new Stack<>();
            for (int i = list.size() - 1; i >= 0; i--) {
                mStack.push(list.get(i));
            }
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            return mStack.pop();
        }

        /** Get the front element. */
        public int peek() {
            return mStack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return mStack.isEmpty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
