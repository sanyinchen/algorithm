//
// Created by sanyinchen on 2020/4/7.
//
#include <iostream>
#include <TreeNode.h>

using namespace std;

class Solution {
public:
    TreeNode *lowestCommonAncestor(TreeNode *root, TreeNode *p, TreeNode *q) {
        if (root == nullptr) {
            return nullptr;
        }
        int pV = p->val;
        int qV = q->val;
        int cV = root->val;
        if (pV > cV && qV > cV) {
            return lowestCommonAncestor(root->right, p, q);
        }

        if (pV < cV && qV < cV) {
            return lowestCommonAncestor(root->left, p, q);
        }
        return root;
    }
};