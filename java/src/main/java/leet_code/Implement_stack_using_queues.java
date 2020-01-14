package leet_code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by sanyinchen on 20-1-14.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-1-14
 */

class Implement_stack_using_queues {
    class MyStack {
        Queue<Integer> mQueue = new LinkedList<>();

        /** Initialize your data structure here. */
        public MyStack() {

        }

        /** Push element x onto stack. */
        public void push(int x) {
            Queue<Integer> newQueue = new LinkedList<>();
            newQueue.add(x);
            while (!mQueue.isEmpty()) {
                newQueue.add(mQueue.poll());
            }
            mQueue = newQueue;
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            if (mQueue.isEmpty()) {
                return -1;
            }
            return mQueue.poll();
        }

        /** Get the top element. */
        public int top() {
            return mQueue.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return mQueue.isEmpty();
        }
    }
}
