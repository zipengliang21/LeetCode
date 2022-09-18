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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }

        TreeNode node = root;

        while (node != null) {
            if (node.val > val) {
                if (node.left != null) {
                    node = node.left;
                } else {
                    node.left = new TreeNode(val);
                    return root;
                }
            } else {
                if (node.right != null) {
                    node = node.right;
                } else {
                    node.right = new TreeNode(val);
                    return root;
                }
            }
        }
        return root;
    }
}