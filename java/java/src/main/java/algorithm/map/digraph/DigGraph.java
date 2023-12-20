package algorithm.map.digraph;

import java.util.Iterator;

import algorithm.bag.Bag;

/**
 * Created by sanyinchen on 19-9-23.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-23
 */

public class DigGraph {
    private final int V; // 顶点数
    private int E; // 边的数目
    private Bag<Integer>[] adj;

    public DigGraph(int V) {
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
        E++;
    }

    public Iterator<Integer> adj(int v) {
        return adj[v].iterator();
    }

    public DigGraph reverse() {
        DigGraph R = new DigGraph(V);
        for (int v = 0; v < V; v++) {
            for (Iterator<Integer> it = adj(v); it.hasNext(); ) {
                int w = it.next();
                R.addEdge(w, v);
            }
        }
        return R;
    }

}
