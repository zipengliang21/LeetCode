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
  int[] preorder, postorder;
  int n;
  int preorderStartIndex;
  Map<Integer, Integer> postMap = new HashMap<>();

  public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
    this.preorder = preorder;
    this.postorder = postorder;
    this.n = preorder.length;
    for (int i = 0; i < n; i++) {
      postMap.put(postorder[i], i);
    }

    return helper(0, n - 1);
  }

  private TreeNode helper(int postStart, int postEnd) {
    // 这题为什么preorderStartIndex >=
    // n。大于好理解，等于是因为下面有preorder[preorderStartIndex++]，等于的话这里就overflow了
    if (preorderStartIndex >= n || postStart > postEnd) {
      return null;
    }

    TreeNode root = new TreeNode(preorder[preorderStartIndex++]);
    // 至于这里，判断preorderStartIndex == n，不判断下面那行就overflow。其次postStart ==
    // postEnd说明上一行创建的node是leaf
    // node了。如果在这里不返回node，代码继续执行，postIndex会得到错误的值，因为它已经是leaf node没有子树，但代码试图还想继续构造子树。

    if (preorderStartIndex == n || postStart == postEnd) {
      return root;
    }
    int postIndex = postMap.get(preorder[preorderStartIndex]);

    root.left = helper(postStart, postIndex);
    root.right = helper(postIndex + 1, postEnd - 1);

    return root;
  }
}