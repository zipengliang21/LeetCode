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
    private int depth;
    public int maxDepth(TreeNode root) {
        depth = 0;

        if (root == null) {
            return depth;
        }
        helper(root, 1);
        
        return depth;
    }

    private void helper(TreeNode root, int curDepth) {
        if (root == null) {
            return; 
        }

        // update the depth only if curDepth > depth
        if (curDepth > depth) {
            depth = curDepth;
        }

        // recursion
        helper(root.left, curDepth + 1);
        helper(root.right, curDepth + 1);
    }
}