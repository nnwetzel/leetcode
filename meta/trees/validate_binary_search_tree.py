"""
Determine if a binary tree is a valid binary search tree (BST).
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
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
        def valid(node: Optional[TreeNode], upper: int, lower: int) -> bool:
            # empty node is valid
            if node is None:
                return True
            # current node must be within bounds
            if not (upper > node.val > lower):
                return False
            # left child's upper bound is current node's value because it must be less
            # right child's lower bound is current node's value because it must be greater
            return valid(node.left, node.val, lower) and valid(node.right, upper, node.val)
        
        # start recursion with infinite bounds
        return valid(root, float('inf'), float('-inf'))