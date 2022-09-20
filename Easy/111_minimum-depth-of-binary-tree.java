/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int minDepth = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root, 1);
        return minDepth;
    }

    private void helper(TreeNode root, int currentDepth) {
        if (root == null) {
            return;
        }

        // only update the minDepth in the left node and currentDepth < minDepth
        if (root.left == null && root.right == null && currentDepth < minDepth) {
            minDepth = currentDepth;
        }

        helper(root.left, currentDepth + 1);
        helper(root.right, currentDepth + 1);
    }
}