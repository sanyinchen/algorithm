package leet_code;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Clone_graph_133 {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
    }

    class Solution {
        Map<Integer, Node> cache = new HashMap<>();

        public Node cloneGraph(Node node) {
            Node rootNode = new Node(node.val);
            rootNode.neighbors = new ArrayList<>();
            cache.put(node.val, rootNode);

            for (Node child : node.neighbors) {
                System.out.println("child:" + child.val);
                if (!cache.containsKey(child.val)) {
                    Node cloneNode = cloneGraph(child);
                    System.out.println("new " + rootNode.val + " => " + cloneNode.val);
                    rootNode.neighbors.add(cloneNode);
                } else {

                    System.out.println("old " + rootNode.val + " => " + child.val);
                    rootNode.neighbors.add(cache.get(child.val));
                    // cache.get(child.val).neighbors.add(rootNode);
                }
            }

            return rootNode;
        }
    }
}
