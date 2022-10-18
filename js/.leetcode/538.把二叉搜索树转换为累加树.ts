/*
 * @lc app=leetcode.cn id=538 lang=typescript
 *
 * [538] 把二叉搜索树转换为累加树
 */
/**
 * Definition for a binary tree node.
 */
class TreeNode {
    val: number
    left: TreeNode | null
    right: TreeNode | null
    constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
        this.val = (val === undefined ? 0 : val)
        this.left = (left === undefined ? null : left)
        this.right = (right === undefined ? null : right)
    }
}


// @lc code=start


function convertBST(root: TreeNode | null): TreeNode | null {
    let list = new Array<TreeNode>()
    let helper = (root: TreeNode | null) => {
        if (root == null) {
            return
        }
        helper(root.left)
        list.push(root)
        helper(root.right)
    }
    helper(root)
    let helper2 = (index: number): number => {
        if (index >= list.length) {
            return 0;
        }
        let childSum = helper2(index + 1)
        list[index].val += childSum
        return list[index].val
    }
    helper2(0)
    return root

};
// @lc code=end

