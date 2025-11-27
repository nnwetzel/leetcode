"""
Return all root-to-leaf paths.
"""
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

from typing import List, Optional

# Time: O(N) - we visit each node once
# Space: O(H) - recursion stack up to height of tree
def binaryTreePaths(root: Optional[TreeNode]) -> List[str]:

    # helper DFS function
    # input node, current path string, list of paths
    def dfs(node, path, paths):
        if not node:
            return
        
        # add current node's value to path
        path += str(node.val)

        # if leaf, add path to results
        if not node.left and not node.right:
            paths.append(path)
        # otherwise, continue DFS
        else:
            path += "->"
            dfs(node.left, path, paths)
            dfs(node.right, path, paths)

    paths = []
    dfs(root, "", paths)
    return paths