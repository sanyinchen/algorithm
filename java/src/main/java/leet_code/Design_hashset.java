package leet_code;


/**
 * Created by sanyinchen on 19-12-19.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-12-19
 */

class Design_hashset {
    static class MyHashSet {
        private static final int INIT_CAPACITY = 100;
        NodeLink[] mNodeLinks;

        /** Initialize your data structure here. */
        public MyHashSet() {
            mNodeLinks = new NodeLink[INIT_CAPACITY];
            for (int i = 0; i < INIT_CAPACITY; i++) {
                mNodeLinks[i] = new NodeLink();
            }
        }

        private int getHasCode(int key) {
            return key % INIT_CAPACITY;
        }

        public void add(int key) {
            mNodeLinks[getHasCode(key)].add(key);
        }

        public void remove(int key) {
            mNodeLinks[getHasCode(key)].remove(key);

        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            int hashCode = getHasCode(key);
            if (mNodeLinks[hashCode].isEmpty()) {
                return false;
            }
            return mNodeLinks[hashCode].contains(key);
        }

        private class Node {
            int value;
            Node next;

            public Node(int value, Node node) {
                this.value = value;
                this.next = node;
            }

        }

        private class NodeLink {
            Node first;
            int n = 0;

            boolean isEmpty() {
                return n == 0 || first == null;
            }

            void add(int value) {
                if (contains(value)) {
                    return;
                }
                first = new Node(value, first);
                n++;

            }

            Node delete(Node node, int value) {
                if (node == null) {
                    return null;
                }
                if (node.value == value) {
                    n--;
                    return node.next;
                }
                node.next = delete(node.next, value);
                return node;
            }

            void remove(int value) {
                if (isEmpty()) {
                    return;
                }
                first = delete(first, value);
            }

            boolean contains(int value) {
                for (Node x = first; x != null; x = x.next) {
                    if (x.value == value) {
                        return true;
                    }
                }
                return false;
            }
        }

    }


}
