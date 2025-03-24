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
  int index, n;
  int[] preorder;

  public TreeNode bstFromPreorder(int[] preorder) {
    this.preorder = preorder;
    this.n = preorder.length;
    return helper(Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private TreeNode helper(int lower, int upper) {
    if (index == n) {
      return null;
    }
    int value = this.preorder[index];
    if (value < lower || value > upper) {
      return null;
    }
    index++;
    TreeNode root = new TreeNode(value);
    root.left = helper(lower, value);
    root.right = helper(value, upper);

    return root;
  }
}