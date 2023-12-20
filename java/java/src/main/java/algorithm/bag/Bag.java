package algorithm.bag;

import java.util.Iterator;

/**
 * Created by sanyinchen on 19-9-23.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-23
 */

public class Bag<T> {

    private Node first;


    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    private class Node {
        T data;
        Node next;
    }

    public Bag<T> add(T data) {
        // mock stack
        Node oldFirst = first;
        first = new Node();
        first.data = data;
        first.next = oldFirst;
        return this;
    }

}
