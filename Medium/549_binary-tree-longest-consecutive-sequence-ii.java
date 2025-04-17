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
  int longest;

  public int longestConsecutive(TreeNode root) {
    dfs(root);
    return longest;
  }

  private int[] dfs(TreeNode root) {
    if (root == null) {
      return new int[] { 0, 0 };
    }
    int inc = 1;
    int dec = 1;

    if (root.left != null) {
      int[] left = dfs(root.left);
      if (root.val == root.left.val + 1) {
        dec = left[1] + 1;
      } else if (root.val == root.left.val - 1) {
        inc = left[0] + 1;
      }
    }

    if (root.right != null) {
      int[] right = dfs(root.right);
      if (root.val == root.right.val + 1) {
        dec = Math.max(dec, right[1] + 1);
      } else if (root.val == root.right.val - 1) {
        inc = Math.max(inc, right[0] + 1);
      }
    }
    longest = Math.max(longest, dec + inc - 1);
    return new int[] { inc, dec };
  }
}