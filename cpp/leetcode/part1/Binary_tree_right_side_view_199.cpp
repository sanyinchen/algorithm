//
// Created by sanyinchen on 2020/4/22.
//
#include <TreeNode.h>

#include <vector>
#include <queue>

using namespace std;

class Solution {
public:


    vector<int> rightSideView(TreeNode *root) {
        vector<int> res;
        if (root == nullptr) {
            return res;
        }
        queue<TreeNode *> nodes;
        nodes.push(root);
        while (!nodes.empty()) {
            int size = nodes.size();
            TreeNode *lastNode;
            while (size-- > 0) {
                lastNode = nodes.front();
                nodes.pop();
                if (lastNode->left != nullptr) {
                    nodes.push(lastNode->left);
                }
                if (lastNode->right != nullptr) {
                    nodes.push(lastNode->right);
                }
            }
            res.push_back(lastNode->val);
        }
        return res;
    }
};