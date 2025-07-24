//
// Created by sanyinchen on 2020/4/7.
//
#include <iostream>
#include <TreeNode.h>

using namespace std;

class Solution {
public:
    TreeNode *invertTree(TreeNode *root) {
        if (root == nullptr) {
            return nullptr;
        }
        TreeNode *left = invertTree(root->left);
        TreeNode *right = invertTree(root->right);
        root->left = right;
        root->right = left;

        return root;
    }
};