package algorithm.map.nodirection;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by sanyinchen on 19-9-24.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-24
 */

public class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s; // 起点

    public DepthFirstPaths(Graph graph, int s) {
        this.s = s;
        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        dfs(graph, s);
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        for (Iterator<Integer> it = graph.adj(v); it.hasNext(); ) {
            int w = it.next();
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(graph, w);
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
