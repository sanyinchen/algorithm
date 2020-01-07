package leet_code;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Stack_and_dfs_884 {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
    }

    class Solution {
        Set<Node> mark = new HashSet<>();

        private void dfs(Node root, Node copyRoot) {
            mark.add(root);
            for (Node node : root.neighbors) {
                if (!mark.contains(node)) {
                    Node copyNode = new Node(node.val);
                    copyNode.neighbors = new ArrayList<>();
                    copyRoot.neighbors.add(node);
                    dfs(node, copyNode);
                }
            }
        }

        public Node cloneGraph(Node node) {
            Node copyNode = new Node(node.val);
            copyNode.neighbors = new ArrayList<>();
            dfs(node, copyNode);
            return copyNode;
        }
    }
}
