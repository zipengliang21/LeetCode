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
class BSTIterator {
  Stack<TreeNode> stack;

  public BSTIterator(TreeNode root) {
    this.stack = new Stack<>();
    pushAllLeft(root);
  }

  public int next() {
    TreeNode node = stack.pop();
    int value = node.val;
    pushAllLeft(node.right);

    return value;
  }

  public boolean hasNext() {
    return !this.stack.isEmpty();
  }

  private void pushAllLeft(TreeNode root) {
    while (root != null) {
      this.stack.push(root);
      root = root.left;
    }
  }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */