//
// Created by sanyinchen on 7/25/25.
//
#include <common.h>


class Solution {
public:
    TreeNode* inorderSuccessor(TreeNode* root, TreeNode* p) {
        int p_value = p->val;
        int res = INT_MAX;
        TreeNode* res_node = nullptr;
        function<void(TreeNode*)> func = [&](TreeNode* root) {
            if (root == nullptr) {
                return;
            }
            func(root->left);
            if (root->val > p_value) {
                cout << root->val << " ";
                if (res > root->val) {
                    res = root->val;
                    res_node = root;
                }
            }
            func(root->right);
        };
        func(root);
        return res_node;
    }
};

int main(int argc, char const* argv[]) {
    Solution s;
    auto* node = new TreeNode(1);
    TreeNode* p = s.inorderSuccessor(build_tree({2, 1, 3}), node);
    cout << endl;
    if (p == nullptr) {
        cout << "p is null" << endl;
    }
    else {
        cout << p->val << endl;
    }
    return 0;
}
