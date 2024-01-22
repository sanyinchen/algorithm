class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next


def build_full_binary_tree(level_order, index):
    if index < len(level_order):
        if level_order[index] is None:
            return None

        root = TreeNode(level_order[index])
        root.left = build_full_binary_tree(level_order, 2 * index + 1)
        root.right = build_full_binary_tree(level_order, 2 * index + 2)
        return root
    return None


def print_level_order(root):
    if not root:
        return

    result = []
    queue = [root]

    while queue:
        current_node = queue.pop(0)
        if current_node is None:
            result.append('#')
            continue
        else:
            result.append(current_node.val)

        if current_node.left:
            queue.append(current_node.left)
        else:
            queue.append(None)

        if current_node.right:
            queue.append(current_node.right)
        else:
            queue.append(None)

    print(result)
