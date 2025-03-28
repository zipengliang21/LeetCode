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
  public TreeNode balanceBST(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    inorder(list, root);
    return builtBalanceBST(list, 0, list.size() - 1);
  }

  private TreeNode builtBalanceBST(List<Integer> list, int start, int end) {
    if (start > end) {
      return null;
    }
    int mid = start + (end - start) / 2;
    TreeNode root = new TreeNode(list.get(mid));
    root.left = builtBalanceBST(list, start, mid - 1);
    root.right = builtBalanceBST(list, mid + 1, end);

    return root;
  }

  private void inorder(List<Integer> list, TreeNode root) {
    if (root == null) {
      return;
    }
    inorder(list, root.left);
    list.add(root.val);
    inorder(list, root.right);
  }
}