package leet_code;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Created by sanyinchen on 20-1-19.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-1-19
 */

class Design_linked_list_707 {
    static class MyLinkedList {

        private class Node {
            int value;
            Node next;

            public Node(int value, Node next) {
                this.value = value;
                this.next = next;
            }
        }

        private class ListIterator implements Iterator<Integer> {
            private Node current;

            public ListIterator(Node first) {
                current = first;
            }

            public boolean hasNext() {
                return current.next != null;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

            public Integer next() {
                if (!hasNext()) throw new NoSuchElementException();
                int item = current.value;
                current = current.next;
                return item;
            }

            public Node nextNode() {
                if (!hasNext()) throw new NoSuchElementException();
                current = current.next;
                return current;
            }
        }

        Node header;

        /** Initialize your data structure here. */
        public MyLinkedList() {
            header = new Node(-1, null);
        }

        private int size() {
            Node temp = header;
            int sum = 0;
            while (temp.next != null) {
                sum++;
                temp = temp.next;
            }
            return sum;
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            // ListIterator listIterator = new ListIterator(header);
            int res = -1;
            int size = size();
            if (index >= size || index < 0) {
                return res;
            }
            Node temp = header.next;
            while (temp != null && index >= 0) {
                res = temp.value;
                temp = temp.next;
                index--;
            }
            return res;
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will
         * be the first node of the linked list.
         */
        public void addAtHead(int val) {
            header.next = new Node(val, header.next);

        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {

            ListIterator listIterator = new ListIterator(header);
            Node tail = header;
            while (listIterator.hasNext() && header.next != null) {
                tail = listIterator.nextNode();
                if (tail.next == null) {
                    break;
                }
            }
            tail.next = new Node(val, null);
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked
         * list, the node will be appended to the end of linked list. If index is greater than the length, the node will
         * not be inserted.
         */
        public void addAtIndex(int index, int val) {
            Node temp = header;
            while (temp != null && index > 0) {
                temp = temp.next;
                index--;
            }
            if (temp == null) {
                return;
            }
            temp.next = new Node(val, temp.next);
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            Node temp = header;
            while (temp != null && index > 0) {
                temp = temp.next;
                index--;
            }
            if (temp == null) {
                return;
            }
            if (temp.next != null) {
                temp.next = temp.next.next;
            }
        }
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        int res = linkedList.get(1);
        System.out.println(res);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);   //链表变为1-> 2-> 3
        res = linkedList.get(1);            //返回2
        System.out.println(res);
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        res = linkedList.get(1);            //返回3
        System.out.println(res);

    }
}
