/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  int count = 0;

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    TreeNode result = helper(root, p, q);
    return count == 2 ? result : null;
  }

  private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }

    TreeNode leftNode = helper(root.left, p, q);
    TreeNode rightNode = helper(root.right, p, q);

    if (root == p || root == q) {
      count++;
      return root;
    }

    return leftNode == null ? rightNode : rightNode == null ? leftNode : root;
  }
}