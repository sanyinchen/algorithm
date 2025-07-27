//
// Created by sanyinchen on 7/26/25.
//
// 线段树
class SegmentTree {
private:
    vector<int> tree;
    int n;

    // 构建线段树
    void build(vector<int>& nums, int node, int l, int r) {
        if (l == r) {
            tree[node] = nums[l];
            return;
        }
        int mid = (l + r) / 2;
        build(nums, 2 * node, l, mid);
        build(nums, 2 * node + 1, mid + 1, r);
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    // 查询区间 [ql, qr] 的和
    int query(int node, int l, int r, int ql, int qr) {
        if (qr < l || ql > r) return 0; // 不相交
        if (ql <= l && r <= qr) return tree[node]; // 完全包含
        int mid = (l + r) / 2;
        return query(2 * node, l, mid, ql, qr) + query(2 * node + 1, mid + 1, r, ql, qr);
    }

    // 单点更新：将 index 的值改为 val
    void update(int node, int l, int r, int index, int val) {
        if (l == r) {
            tree[node] = val;
            return;
        }
        int mid = (l + r) / 2;
        if (index <= mid)
            update(2 * node, l, mid, index, val);
        else
            update(2 * node + 1, mid + 1, r, index, val);
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

public:
    SegmentTree(vector<int>& nums) {
        n = nums.size();
        tree.resize(n * 4);
        build(nums, 1, 0, n - 1);
    }

    int query(int l, int r) {
        return query(1, 0, n - 1, l, r);
    }

    void update(int index, int val) {
        update(1, 0, n - 1, index, val);
    }
};
