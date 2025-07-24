//
// Created by sanyinchen on 2020/4/1.
//


#include <TreeNode.h>


#include <iostream>
#include <climits>

using namespace std;

class Solution {
public:
//    int mHeight = INT_MAX;
//
//    void minDepthHelper(TreeNode *root, int height) {
//        if (root == nullptr) {
//            cout << mHeight << " " << height << endl;
//            mHeight = min(height, mHeight);
//            return;
//        }
//        height++;
//        minDepthHelper(root->left, height);
//        minDepthHelper(root->right, height);
//    }

    int minDepth(TreeNode *root) {
        if (root == nullptr) {
            return 0;
        }
        if (root->left == nullptr && root->right == nullptr) {
            return 1;
        }
        int min = INT_MAX;
        if (root->left != nullptr) {
            int temp = minDepth(root->left);
            min = temp < min ? temp : min;
        }

        if (root->right != nullptr) {
            int temp = minDepth(root->right);
            min = temp < min ? temp : min;
        }
        return min + 1;
    }
};