package leet_code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import leet_code.common.TreeNode;

/**
 * Created by sanyinchen on 20-1-6.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 20-1-6
 */

class Find_duplicate_subtrees_652 {
    class Solution {
        StringBuilder tempKey = new StringBuilder();
        List<TreeNode> res = new ArrayList<>();
        Map<String, List<TreeNode>> map = new HashMap<>();


        private void scanTree(TreeNode root) {
            if (root == null) {

                tempKey.append("null").append("#");
                return;
            }
            tempKey.append(root.val).append("#");
            scanTree(root.left);
            scanTree(root.right);
        }

        private String getThreeNodeSerialize(TreeNode root) {
            if (root == null) {
                return "";
            }
            tempKey.setLength(0);
            scanTree(root);
            System.out.println("tempKey:" + tempKey.toString());
            return tempKey.toString();
        }

        private void scanTree2Res(TreeNode root) {
            if (root == null) {
                return;
            }
            String hashcode = getThreeNodeSerialize(root);
            if (!map.containsKey(hashcode)) {
                map.put(hashcode, new ArrayList<>());
            }
            map.get(hashcode).add(root);
            scanTree2Res(root.left);
            scanTree2Res(root.right);
        }

        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            scanTree2Res(root);
            List<TreeNode> treeNodes = new ArrayList<>();
            for (Map.Entry<String, List<TreeNode>> item : map.entrySet()) {
                if (item.getValue().size() > 1) {
                    treeNodes.add(item.getValue().get(0));
                }
            }


            return treeNodes;
        }
    }
}
