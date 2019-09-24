package algorithm.map.digraph;

import java.util.Stack;

import algorithm.map.nodirection.BreadthFirstPaths;
import algorithm.map.nodirection.Graph;

/**
 * Created by sanyinchen on 19-9-23.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-23
 */

public class DidgGraphTest {
    public static void main(String[] args) {
        DigGraph graph = new DigGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(1, 4);

        DigBreadthFirstPaths breadthFirstPaths = new DigBreadthFirstPaths(graph, 0);
        Stack<Integer> path = breadthFirstPaths.pathTo(4);
        while (!path.isEmpty()) {
            System.out.print(path.pop() + " ");
        }
    }
}
