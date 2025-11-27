from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Time: O(N) - visit each node once
# Space: O(H) - recursion stack up to height of tree
class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        diameter = 0

        # helper function to compute height and update diameter
        def height(node):
            # use nonlocal to allow updating diameter variable
            nonlocal diameter
            # base case: empty node has height 0
            if not node:
                return 0

            # compute heights of left and right subtrees
            left_height = height(node.left)
            right_height = height(node.right)

            # update diameter if path through this node is larger
            diameter = max(diameter, left_height + right_height)

            # return height of this node
            return 1 + max(left_height, right_height)

        height(root)
        return diameter