package leet_code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leet_code.common.TreeNode;

public class Lowest_common_ancestor_of_a_binary_tree_236 {
    class Solution {
        private void dfs(TreeNode root, TreeNode searched, List<TreeNode> container, List<TreeNode> containerCopy) {
            if (root == null) {
                return;
            }
            container.add(root);
            if (root == searched) {
                containerCopy.clear();
                containerCopy.addAll(container);
                return;
            }
            dfs(root.left, searched, container, containerCopy);
            // container.remove(root);
            dfs(root.right, searched, container, containerCopy);
            container.remove(root);

        }

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            List<TreeNode> resP = new ArrayList<>();
            dfs(root, p, new ArrayList<>(), resP);
            List<TreeNode> resq = new ArrayList<>();
            dfs(root, q, new ArrayList<>(), resq);
            Collections.reverse(resP);
            Collections.reverse(resq);

            for (int i = 0; i < resP.size(); i++) {
                for (int j = 0; j < resq.size(); j++) {
                    if (resP.get(i) == resq.get(j)) {
                        return resP.get(i);
                    }
                }
            }
            return null;
        }
    }
}
