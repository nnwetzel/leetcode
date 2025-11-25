"""
Create a new BST containing only the nodes within [min, max].
"""

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

from typing import Optional

# Time: O(N) - we visit each node once
# Space: O(H) - recursion stack up to height of tree
class Solution:
    def filterBST(self, root: Optional[TreeNode], min: int, max: int) -> Optional[TreeNode]:
        
        if not root:
            return None
        
        # skip left subtree if current value is too small
        if root.val < min:
            return self.filterBST(root.right, min, max)

        # skip right subtree if current value is too large
        if root.val > max:
            return self.filterBST(root.left, min, max)

        # node is in range, create new node and recursively filter children
        new_node = TreeNode(root.val)
        new_node.left = self.filterBST(root.left, min, max)
        new_node.right = self.filterBST(root.right, min, max)
        # return the new subtree
        return new_node