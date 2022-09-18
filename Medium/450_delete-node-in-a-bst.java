/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            // means already find the value key

            if (root.left == null && root.right == null) {
                // case 1: no subtree
                root = null;
            } else if (root.right == null) {
                // case 2.1: only left subtree
                root = root.left;
            } else if (root.left == null) {
                // case 2.1: only right subtree
                root = root.right;
            } else {
                // case 3: root has two subtrees
                // 3.1 find the successor from the right subtree
                TreeNode successor = getSuccessor(root.right);
                root.val = successor.val;

                // 3.2 delete the successor in the right subtree using this method recursively
                TreeNode newRight = deleteNode(root.right, successor.val);

                // 3.3 set the new right sub tree
                root.right = newRight;
            }
        }

        return root;
    }

    private TreeNode getSuccessor(TreeNode root) {
        if (root.left == null) {
            return root;
        }

        return getSuccessor(root.left);
    }
}