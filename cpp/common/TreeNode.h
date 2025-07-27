#include <iostream>
#include <optional>
#include <queue>
#include <vector>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;

    TreeNode(int x) : val(x), left(NULL), right(NULL) {
    }
};

inline TreeNode *build_tree(const vector<optional<int> > &nodes) {
    if (nodes.empty() || !nodes[0].has_value()) return nullptr;

    TreeNode *root = new TreeNode(nodes[0].value());
    queue<TreeNode *> q;
    q.push(root);
    int i = 1;

    while (!q.empty() && i < nodes.size()) {
        TreeNode *curr = q.front();
        q.pop();

        if (i < nodes.size() && nodes[i].has_value()) {
            curr->left = new TreeNode(nodes[i].value());
            q.push(curr->left);
        }
        i++;

        if (i < nodes.size() && nodes[i].has_value()) {
            curr->right = new TreeNode(nodes[i].value());
            q.push(curr->right);
        }
        i++;
    }

    return root;
}
