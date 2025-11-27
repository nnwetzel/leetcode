from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        # helper DFS function to accumulate sum
        def dfs(node):
            nonlocal ans
            if node:
                # add node's value if in range
                if low <= node.val <= high:
                    ans += node.val
                # traverse left subtree if potential values in range
                if low < node.val:
                    dfs(node.left)
                # traverse right subtree if potential values in range
                if node.val < high:
                    dfs(node.right)
        ans = 0
        dfs(root)
        return ans