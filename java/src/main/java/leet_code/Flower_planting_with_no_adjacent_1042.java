package leet_code;


import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;


/**
 * Created by sanyinchen on 19-10-10.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-10
 */

class Flower_planting_with_no_adjacent_1042 {
    static class Solution {
        private Set<Integer> getColors() {
            Set<Integer> set = new HashSet<>();
            set.add(1);
            set.add(2);
            set.add(3);
            set.add(4);
            return set;
        }

        public int[] gardenNoAdj(int N, int[][] paths) {
            Graph graph = new Graph(N);
            for (int i = 0; i < paths.length; i++) {
                int[] item = paths[i];
                graph.addEdge(item[0] - 1, item[1] - 1);
            }
            int[] ids = new int[N];
            for (int i = 0; i < N; i++) {
                Set<Integer> colors = getColors();
                for (int v : graph.adj(i)) {
                    colors.remove(ids[v]);
                }
                for (int c : colors) {
                    ids[i] = c;
                    break;
                }
            }


            return ids;
        }

        private class Node<Item> {
            private Item item;
            private Node<Item> next;
        }

        private class Graph {
            private final int V;
            private int E;
            private Bag<Integer>[] adj;

            public Graph(int V) {
                if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
                this.V = V;
                this.E = 0;
                adj = (Bag<Integer>[]) new Bag[V];
                for (int v = 0; v < V; v++) {
                    adj[v] = new Bag<Integer>();
                }
            }

            public int V() {
                return V;
            }

            public int E() {
                return E;
            }

            public void addEdge(int v, int w) {
                validateVertex(v);
                validateVertex(w);
                E++;
                adj[v].add(w);
                adj[w].add(v);
            }

            public Iterable<Integer> adj(int v) {
                validateVertex(v);
                return adj[v];
            }

            public int degree(int v) {
                validateVertex(v);
                return adj[v].size();
            }

            private void validateVertex(int v) {
                if (v < 0 || v >= V) {
                    throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
                }
            }
        }

        private class ListIterator<Item> implements Iterator<Item> {
            private Node<Item> current;

            public ListIterator(Node<Item> first) {
                current = first;
            }

            public boolean hasNext() {
                return current != null;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

            public Item next() {
                if (!hasNext()) throw new NoSuchElementException();
                Item item = current.item;
                current = current.next;
                return item;
            }
        }

        private class Bag<Item> implements Iterable<Item> {
            private Node<Item> first;    // beginning of bag
            private int n;               // number of elements in bag

            public Bag() {
                first = null;
                n = 0;
            }

            public boolean isEmpty() {
                return first == null;
            }

            public int size() {
                return n;
            }

            public void add(Item item) {
                Node<Item> oldfirst = first;
                first = new Node<Item>();
                first.item = item;
                first.next = oldfirst;
                n++;
            }

            @Override
            public Iterator<Item> iterator() {
                return new ListIterator<Item>(first);
            }
        }

    }

    public static void main(String[] args) {
        // int n = 4;
        // int[][] paths = {{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 3}, {2, 4}};
        int n = 5;
        int[][] paths = {{4, 1}, {4, 2}, {4, 3}, {2, 5}, {1, 2}, {1, 5}};
        int[] res = new Solution().gardenNoAdj(n, paths);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
