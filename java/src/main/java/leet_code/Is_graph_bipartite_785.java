package leet_code;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by sanyinchen on 19-10-11.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-10-11
 */

class Is_graph_bipartite_785 {
    class Solution {
        public boolean isBipartite(int[][] graph) {
            Graph realGraph = new Graph(graph.length);
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph[i].length; j++) {
                    realGraph.addEdge(i, graph[i][j]);
                }

            }
            return new BipartiteGraph(realGraph).isBipartiteGraph();
        }

        private class BipartiteGraph {
            final boolean[] bipartiteRecord;
            final boolean[] marked;
            boolean isBipartiteGraph;

            public BipartiteGraph(Graph graph) {
                bipartiteRecord = new boolean[graph.V()];
                marked = new boolean[graph.V()];
                isBipartiteGraph = true;
                for (int s = 0; s < graph.V(); s++) {
                    if (!marked[s]) {
                        dfs(graph, s);
                    }
                }
            }

            public boolean isBipartiteGraph() {
                return isBipartiteGraph;
            }

            private void dfs(Graph graph, int v) {
                if (!isBipartiteGraph) {
                    return;
                }
                marked[v] = true;
                for (int w : graph.adj(v)) {
                    if (!marked[w]) {
                        bipartiteRecord[w] = !bipartiteRecord[v];
                        dfs(graph, w);
                    } else {
                        if (bipartiteRecord[v] == bipartiteRecord[w]) {
                            isBipartiteGraph = false;
                        }
                    }
                }
            }
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

}
