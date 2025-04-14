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
  double result = 0.0;

  public double maximumAverageSubtree(TreeNode root) {
    helper(root);
    return result;
  }

  private int[] helper(TreeNode root) {
    if (root == null) {
      return new int[2];
    }

    int[] res = new int[2];
    int[] left = helper(root.left);
    int[] right = helper(root.right);
    res[0] = left[0] + right[0] + root.val;
    res[1] = left[1] + right[1] + 1;
    result = Math.max(result, (double) res[0] / (double) res[1]);

    return res;
  }
}