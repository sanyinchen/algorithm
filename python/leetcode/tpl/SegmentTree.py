# http://toughcoder.net/blog/2022/08/23/rmq-made-easy/
class SegmentTree:
    def __init__(self, nums):
        self.n = len(nums)
        # 构造满二叉树
        self.tree = [0] * (4 * self.n)
        self.build(nums, 1, 0, self.n - 1)

    def build(self, nums, node, start, end):
        if start == end:
            self.tree[node] = nums[start]
        else:
            # 执行整数除法并向下取整
            mid = (start + end) // 2
            self.build(nums, 2 * node, start, mid)
            self.build(nums, 2 * node + 1, mid + 1, end)
            self.tree[node] = self.tree[2 * node] + self.tree[2 * node + 1]

    def update(self, index, value):
        def update_node(node, start, end):
            if start == end:
                print(node, value)
                self.tree[node] = value
            else:
                # 执行整数除法并向下取整
                mid = (start + end) // 2
                if start <= index <= mid:
                    update_node(2 * node, start, mid)
                else:
                    update_node(2 * node + 1, mid + 1, end)
                self.tree[node] = self.tree[2 * node] + self.tree[2 * node + 1]

        update_node(1, 0, self.n - 1)

    def query(self, query_start, query_end):
        def query_range(node, start, end, query_start, query_end):
            if query_start > end or query_end < start:
                return 0
            if query_start <= start and query_end >= end:
                return self.tree[node]
            mid = (start + end) // 2
            left_sum = query_range(2 * node, start, mid, query_start, query_end)
            right_sum = query_range(2 * node + 1, mid + 1, end, query_start, query_end)
            return left_sum + right_sum

        return query_range(1, 0, self.n - 1, query_start, query_end)


# 测试
nums = [1, 2, 3]
seg_tree = SegmentTree(nums)
print("线段树结构创建成功")
#
# print("线段树查询结果：")
# print("nums[0:2] 的区间和为：", seg_tree.query(0, 2))
# print("nums[1:4] 的区间和为：", seg_tree.query(1, 4))

print("更新后，nums[1:4] 的区间和为：", seg_tree.query(0, 3))

seg_tree.update(0, 6)
print("更新后，nums[1:4] 的区间和为：", seg_tree.query(0, 3))
