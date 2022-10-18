"use strict";
/*
 * @lc app=leetcode.cn id=538 lang=typescript
 *
 * [538] 把二叉搜索树转换为累加树
 */
/**
 * Definition for a binary tree node.
 */
class TreeNode {
    constructor(val, left, right) {
        this.val = (val === undefined ? 0 : val);
        this.left = (left === undefined ? null : left);
        this.right = (right === undefined ? null : right);
    }
}
// @lc code=start
function convertBST(root) {
    let list = new Array();
    let helper = (root) => {
        if (root == null) {
            return;
        }
        helper(root.left);
        list.push(root);
        helper(root.right);
    };
    helper(root);
    let helper2 = (index) => {
        if (index >= list.length) {
            return 0;
        }
        let childSum = helper2(index + 1);
        list[index].val += childSum;
        return list[index].val;
    };
    helper2(0);
    return root;
}
;
// @lc code=end
//# sourceMappingURL=538.%E6%8A%8A%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91%E8%BD%AC%E6%8D%A2%E4%B8%BA%E7%B4%AF%E5%8A%A0%E6%A0%91.js.map