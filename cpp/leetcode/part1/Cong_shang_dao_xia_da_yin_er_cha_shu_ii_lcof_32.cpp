//
// Created by sanyinchen on 2020/6/5.
//
#include <iostream>
#include <vector>
#include <TreeNode.h>
#include <queue>

using namespace std;

class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode *root) {
        vector<vector<int >> res;
        if (root == nullptr) {
            return res;
        }
        queue<TreeNode *> header;
        header.push(root);
        while (!header.empty()) {
            int size = header.size();
            vector<int> level;
            while (size-- > 0) {
                TreeNode *temp = header.front();
                level.push_back(temp->val);
                if (temp->left != nullptr) {
                    header.push(temp->left);
                }
                if (temp->right != nullptr) {
                    header.push(temp->right);
                }
                header.pop();
            }
            if (!level.empty()) {
                res.push_back(level);
            }
        }
        return res;
    }
};
