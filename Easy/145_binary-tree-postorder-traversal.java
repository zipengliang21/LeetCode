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
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        postorderTraversalWithRecursion(root, result);
        return result;
    }

    private void postorderTraversalWithRecursion(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        postorderTraversalWithRecursion(root.left, result);
        postorderTraversalWithRecursion(root.right, result);
        result.add(root.val);
    }
}