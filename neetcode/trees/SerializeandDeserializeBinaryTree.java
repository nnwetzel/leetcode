/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // THOUGHT PROCESS:
    // Use preorder (node, left, right) with explicit "null" tokens so the exact tree shape
    // is preserved and can be rebuilt by consuming tokens in order.
    // Time: O(n). Space: O(n).

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // PSUEODCODE:
        // 1. If the node is null:
        //    - Add "null," to the serialized string
        // 2. Otherwise:
        //    - Add the node value and a comma
        //    - Serialize the left child
        //    - Serialize the right child

        // Use preorder traversal with explicit null markers.
        return dfsSerialize(root, new StringBuilder()).toString();
    }

    // Preorder helper: append "null," for missing nodes, otherwise "value," then children.
    private StringBuilder dfsSerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            // mark absent child so structure is preserved
            sb.append("null,");
        }
        else {
            // write node value
            sb.append(root.val).append(",");
            // serialize left subtree (preorder)
            dfsSerialize(root.left, sb);
            // serialize right subtree (preorder)
            dfsSerialize(root.right, sb);
        }
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // PSEUDOCODE:
        // 1. Split the serialized string into tokens (left-to-right).
        // 2. Read the next token:
        //    - If it's "null", return null.
        //    - Otherwise create a node with that value.
        //    - Recursively build its left child, then its right child.
        //    - Return the node.

        // split into tokens and consume in order to rebuild the tree
        List<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return dfsDeserialize(nodes);
    }

    // consume next token: "null" -> null; otherwise create node and build left/right.
    private TreeNode dfsDeserialize(List<String> nodes) {
        if (nodes.isEmpty()) return null;

        // take the next token
        String val = nodes.remove(0);
        // empty marker -> no node here
        if (val.equals("null")) return null;

        // create node and recursively build children
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = dfsDeserialize(nodes);
        root.right = dfsDeserialize(nodes);
        return root;
    }
}

// Example usage:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));