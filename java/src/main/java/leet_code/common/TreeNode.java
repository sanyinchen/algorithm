package leet_code.common;


import org.json.JSONArray;

/**
 * Created by sanyinchen on 19-9-14.
 *
 * @author sanyinchen
 * @version v0.1
 * @since 19-9-14
 */

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

//    public static TreeNode create(String data) {
//        JSONArray jsonArray = new JSONArray(data);
//        for (int i = 0; i < jsonArray.length(); i++) {
//            System.out.println(jsonArray.get(i));
//        }
//        return null;
//    }
}
