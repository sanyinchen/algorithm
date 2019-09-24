package leet_code;

import java.util.Iterator;
import java.util.LinkedList;

import algorithm.map.digraph.DigBreadthFirstPaths;


public class Find_the_town_judge {
    public static class Solution {

        pr
        public int findJudge(int N, int[][] trust) {
            JudgeDigGraph judgeDigGraph = new JudgeDigGraph(N + 1);
            for (int i = 0; i < trust.length; i++) {
                judgeDigGraph.addEdge(trust[i][0], trust[i][1]);
            }
            for (int i = 1; i < judgeDigGraph.V(); i++) {
                System.out.println("===>" + i + " " + judgeDigGraph.adjSize(i));
                if (judgeDigGraph.adjSize(i) == 0) {
                    boolean isJudge = true;
                    for (int j = 1; j < judgeDigGraph.V(); j++) {
                        if (j == i) {
                            continue;
                        }
                        System.out.println("j:" + j);

                    }
                    if (!isJudge) {
                        continue;
                    }

                    return i;
                }
            }
            return -1;
        }

        public class JudgeDigGraph {
            private final int V; // 顶点数
            private int E; // 边的数目
            private Bag<Integer>[] adj;

            public JudgeDigGraph(int V) {
                this.V = V;
                this.E = 0;
                adj = (Bag<Integer>[]) new Bag[V];
                for (int v = 0; v < V; v++) {
                    adj[v] = new Bag<>();
                }
            }

            public int V() {
                return V;
            }

            public int E() {
                return E;
            }

            /**
             * 添加无向图
             *
             * @param v
             * @param w
             */
            public void addEdge(int v, int w) {
                System.out.println("v:" + v + " w:" + w);
                adj[v].add(w);
                E++;
            }

            public Iterator<Integer> adj(int v) {
                return adj[v].iterator();
            }

            public boolean isJudge(int v) {
                Iterator<Integer> i terator = adj(v);
                int size = 0;
                while (iterator.hasNext()) {
                    size++;
                    iterator.next();
                }
                if (size != 0) {
                    return false;
                }



                return true;
            }


        }

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
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] data = new int[][]{
                {1, 2},
                {2, 3}
        };
        System.out.println("==>" + new Solution().findJudge(n, data));
    }
}
