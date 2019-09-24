package algorithm.map.nodirection;

import java.util.Iterator;

import algorithm.bag.Bag;

/**
 * Created by sanyinchen on 19-9-23.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-23
 */

public class Graph {
    private final int V; // 顶点数
    private int E; // 边的数目
    private Bag<Integer>[] adj;

    public Graph(int V) {
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
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterator<Integer> adj(int v) {
        return adj[v].iterator();
    }

}
