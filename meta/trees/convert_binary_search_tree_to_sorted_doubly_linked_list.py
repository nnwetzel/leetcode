# Definition for a Node.
class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

from typing import Optional

# Time: O(N) - we visit each node once
# Space: O(H) - recursion stack up to height of tree
class Solution:
    def treeToDoublyList(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root:
            return None

        def helper(node):
            """Return (head, tail) of the DLL for this subtree."""
            if not node:
                return None, None

            # recursively convert left and right subtrees
            left_head, left_tail = helper(node.left)
            right_head, right_tail = helper(node.right)

            # connect left list to current node
            if left_tail:
                left_tail.right = node
                node.left = left_tail
            else:
                left_head = node

            # connect current node to right list
            if right_head:
                right_head.left = node
                node.right = right_head
            else:
                right_tail = node

            # return the new subtree's head and tail
            return left_head, right_tail

        # get head and tail of the full list
        head, tail = helper(root)

        # make it circular
        head.left = tail
        tail.right = head
        return head