package algorithm.map.nodirection;

import java.util.Stack;

/**
 * Created by sanyinchen on 19-9-23.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-23
 */

public class GraphTest {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(1, 4);

        BreadthFirstPaths breadthFirstPaths = new BreadthFirstPaths(graph, 0);
        Stack<Integer> path = breadthFirstPaths.pathTo(4);
        while (!path.isEmpty()) {
            System.out.print(path.pop() + " ");
        }
    }
}
