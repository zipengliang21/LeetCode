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
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        inorderTraversalWithRecursion(root, result);
        return result;
    }

    private void inorderTraversalWithRecursion(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        inorderTraversalWithRecursion(root.left, result);
        result.add(root.val);
        inorderTraversalWithRecursion(root.right, result);
    }
}