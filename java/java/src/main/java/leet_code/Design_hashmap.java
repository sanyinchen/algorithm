package leet_code;

/**
 * Created by sanyinchen on 19-12-19.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-12-19
 */

class Design_hashmap {
    static class MyHashMap {
        private static final int INIT_CAPACITY = 100;
        NodeLink[] mNodeLinks;

        /** Initialize your data structure here. */
        public MyHashMap() {
            mNodeLinks = new NodeLink[INIT_CAPACITY];
            for (int i = 0; i < INIT_CAPACITY; i++) {
                mNodeLinks[i] = new NodeLink();
            }
        }

        private int getHasCode(int key) {
            return key % INIT_CAPACITY;
        }

        public void put(int key, int value) {
            mNodeLinks[getHasCode(key)].add(key, value);
        }

        public int get(int key) {
            return mNodeLinks[getHasCode(key)].get(key);
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
            int key;
            Node next;

            public Node(int key, int value, Node node) {
                this.value = value;
                this.key = key;
                this.next = node;
            }

        }

        private class NodeLink {
            Node first;
            int n = 0;

            boolean isEmpty() {
                return n == 0 || first == null;
            }

            void add(int key, int value) {
                Node node = getNode(key);
                if (node != null) {
                    node.value = value;
                    return;
                }
                first = new Node(key, value, first);
                n++;

            }

            Node delete(Node node, int key) {
                if (node == null) {
                    return null;
                }
                if (node.key == key) {
                    n--;
                    return node.next;
                }
                node.next = delete(node.next, key);
                return node;
            }

            void remove(int key) {
                if (isEmpty()) {
                    return;
                }
                first = delete(first, key);
            }


            private Node getNode(int key) {
                for (Node x = first; x != null; x = x.next) {
                    if (x.key == key) {
                        return x;
                    }
                }
                return null;
            }

            int get(int key) {
                Node node = getNode(key);
                if (node == null) {
                    return -1;
                }
                return node.value;
            }

            boolean contains(int key) {
                return getNode(key) != null;
            }
        }

    }
}
