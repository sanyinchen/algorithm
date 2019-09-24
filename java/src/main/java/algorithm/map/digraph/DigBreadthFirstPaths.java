package algorithm.map.digraph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

import algorithm.map.nodirection.Graph;

/**
 * Created by sanyinchen on 19-9-24.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-24
 */

public class DigBreadthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public DigBreadthFirstPaths(DigGraph graph, int s) {
        this.s = s;
        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        bfs(graph, s);
    }

    private void bfs(DigGraph graph, int s) {
        LinkedList<Integer> queue = new LinkedList<>();
        marked[s] = true;
        queue.push(s);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (Iterator<Integer> it = graph.adj(v); it.hasNext(); ) {
                int w = it.next();
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.push(w);

                }

            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Stack<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
