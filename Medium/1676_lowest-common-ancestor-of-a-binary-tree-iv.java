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
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
    Set<Integer> map = new HashSet<>();
    for (TreeNode node : nodes) {
      map.add(node.val);
    }
    return dfs(root, map);
  }

  private TreeNode dfs(TreeNode root, Set<Integer> map) {
    if (root == null) {
      return null;
    }

    if (map.contains(root.val)) {
      return root;
    }

    TreeNode left = dfs(root.left, map);
    TreeNode right = dfs(root.right, map);

    if (left != null && right != null) {
      return root;
    }

    return left != null ? left : right;
  }
}