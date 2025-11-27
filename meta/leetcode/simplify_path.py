# Time: O(N) - process each component of path
# Space: O(N) - stack to hold valid path components
class Solution:
    def simplifyPath(self, path: str) -> str:
        # use a stack to process the path components
        stack = []

        # split path by '/' and process each portion
        for portion in path.split('/'):
            # if "..", pop from stack if possible
            if portion == "..":
                if stack:
                    stack.pop()
            # ignore "." and empty portions
            elif portion == "." or not portion:
                continue
            # valid directory name, push onto stack
            else:
                stack.append(portion)
        # join stack to form simplified path
        return "/" + "/".join(stack)