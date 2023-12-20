package leet_code;

import java.util.LinkedList;
import java.util.Queue;

import leet_code.common.TreeNode;

public class Serialize_and_deserialize_binary_tree_297 {
    private static void scan(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        scan(root.left);
        scan(root.right);
    }

    static public class Codec {


        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder str = new StringBuilder();
            if (root == null) {
                str.append("NULL").append("#");
                return str.toString();
            }
            str.append(root.val).append("#");
            str.append(serialize(root.left));
            str.append(serialize(root.right));
            return str.toString();
        }

        private String getValue(String[] orders, int index) {
            if (index < 0 || index > orders.length) {
                return null;
            }
            return orders[index];
        }

        private int index = 0;

        private TreeNode deCode(String[] orders) {

            String val = getValue(orders, index++);

            System.out.println("index:" + index);
            if (val == null || "NULL".equals(val)) {
                return null;
            }
            int value = Integer.parseInt(val);
            TreeNode treeNode = new TreeNode(value);
            treeNode.left = deCode(orders);
            treeNode.right = deCode(orders);
            return treeNode;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {

            String[] splits = data.split("#");
            index = 0;
            return deCode(splits);
        }
    }

    public static void main(String[] args) {

        Codec codec = new Codec();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String encode = codec.serialize(root);
        System.out.println("encode:" + encode);
        TreeNode treeNode = codec.deserialize(encode);
        scan(treeNode);
    }
}
