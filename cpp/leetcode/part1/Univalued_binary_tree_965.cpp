//
// Created by sanyinchen on 2020/4/12.
//
#include <TreeNode.h>
#include <iostream>

using namespace std;

class Solution {
public:
    int cache[101] = {0};

    void isUnivalTreeHelper(TreeNode *root) {
        if (root == nullptr) {
            return;
        }
        cache[root->val]++;
        isUnivalTreeHelper(root->left);
        isUnivalTreeHelper(root->right);
    }

    bool isUnivalTree(TreeNode *root) {
        isUnivalTreeHelper(root);
        int sum = 0;
        for (int i = 0; i < 101; i++) {
            if (cache[i] != 0) {
                sum++;
            }
        }
        return sum == 1;
    }
};