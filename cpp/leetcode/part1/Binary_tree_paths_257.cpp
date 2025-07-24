//
// Created by Administrator on 2020年04月06日, 0006.
//
#include <TreeNode.h>
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<string> res;

    void binaryTreePathsHelper(TreeNode *root, vector<int> paths) {
        if (root == nullptr) {
            return;
        }
        if (root->left == nullptr && root->right == nullptr) {
            string temp;
            for (int i = 0; i < paths.size(); i++) {
                int item = paths[i];
                temp += (to_string(item) + "->");
            }
            temp += to_string(root->val);
            res.push_back(temp);
            return;
        }
        paths.push_back(root->val);
        binaryTreePathsHelper(root->left, paths);
        binaryTreePathsHelper(root->right, paths);
    }

    vector<string> binaryTreePaths(TreeNode *root) {
        vector<int> paths;
        binaryTreePathsHelper(root, paths);
        return res;
    }
};