//
// Created by Administrator on 2020年03月29日, 0029.
//

#include <TreeNode.h>
#include <iostream>
#include <vector>
#include <queue>
#include <stack>

using namespace std;

class Solution {
public:
    vector<vector<int>> levelOrderBottom(TreeNode *root) {
        vector<vector<int>> res;
        if (root == nullptr) {
            return res;
        }
        stack<vector<int>> stack_res;
        queue<TreeNode *> nodes;
        nodes.push(root);

        while (!nodes.empty()) {
            int size = nodes.size();
            vector<int> item;
            while (size-- > 0) {
                TreeNode *temp = nodes.front();
                item.push_back(temp->val);
                nodes.pop();
                TreeNode *left = temp->left;
                TreeNode *right = temp->right;
                if (left != nullptr) {
                    nodes.push(left);
                }
                if (right != nullptr) {
                    nodes.push(right);
                }
            }
            stack_res.push(item);
        }
        while (!stack_res.empty()) {
            res.push_back(stack_res.top());
            stack_res.pop();
        }
        return res;
    }
};

int main() {
    queue<int> test;
    test.push(1);
    test.push(2);
    cout << test.front() << " " << test.size();
    return 0;
}