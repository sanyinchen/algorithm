//
// Created by sanyinchen on 2025/7/24.
//
#include <common.h>

class Solution {
public:
    int largestBSTSubtree(TreeNode *root) {
        function<bool(TreeNode *, long long &, int &)> is_valid_bst = [&](TreeNode *node, long long &prev, int &count) {
            if (!node) return true;
            if (!is_valid_bst(node->left, prev, count)) return false;
            if (node->val <= prev) return false;
            prev = node->val;
            count++;
            if (!is_valid_bst(node->right, prev, count)) return false;
            return true;
        };

        function<int(TreeNode *)> get_largest_bst = [&](TreeNode *sub_root) {
            if (!sub_root) return 0;

            long long prev = LONG_MIN;
            int count = 0;
            if (is_valid_bst(sub_root, prev, count)) {
                return count;
            }
            return max(get_largest_bst(sub_root->left), get_largest_bst(sub_root->right));
        };

        return get_largest_bst(root);
    }
};

int main() {
    Solution s;
    cout << s.largestBSTSubtree(build_tree({10, 5, 15, 1, 8, nullopt, 7})) << endl;
    return 0;
}
