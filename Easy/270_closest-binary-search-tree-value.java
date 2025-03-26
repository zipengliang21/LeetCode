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
  int result = 0;
  double min = Double.MAX_VALUE;

  public int closestValue(TreeNode root, double target) {
    dfs(root, target);
    return result;
  }

  private void dfs(TreeNode root, double target) {
    if (root == null) {
      return;
    }

    int val = root.val;
    if (Math.abs(val - target) < min) {
      result = val;
      min = Math.abs(val - target);
    } else if (Math.abs(val - target) == min) {
      result = Math.min(result, val);
    }

    if (val < target) {
      dfs(root.right, target);
    } else {
      dfs(root.left, target);
    }
  }
}