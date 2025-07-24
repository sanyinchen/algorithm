//
// Created by Administrator on 2020年03月29日, 0029.
//
#include <iostream>
#include <TreeNode.h>

using namespace std;

class Solution {
public:
    bool isBalance = true;

    int getTreeHeight(TreeNode *root) {
        if (root == nullptr) {
            return 0;
        }
        int leftHeight = getTreeHeight(root->left) + 1;
        int rightHeight = getTreeHeight(root->right) + 1;
        if (abs(leftHeight - rightHeight) > 1) {
            isBalance = false;
        }
        if (!isBalance) {
            return -1;
        }
        return leftHeight > rightHeight ? leftHeight : rightHeight;
    }

    bool isBalanced(TreeNode *root) {
        if (root != nullptr) {
            getTreeHeight(root);
        }
        return isBalance;
    }
};