/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if (root == null) {
      return "";
    }
    StringBuffer sb = new StringBuffer();
    sb.append(String.valueOf(root.val));
    if (root.left != null) {
      sb.append("," + serialize(root.left));
    }
    if (root.right != null) {
      sb.append("," + serialize(root.right));
    }
    return sb.toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data == null || data.equals("")) {
      return null;
    }
    Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
    return helper(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private TreeNode helper(Queue<String> queue, int lower, int upper) {
    if (queue.isEmpty()) {
      return null;
    }
    int val = Integer.parseInt(queue.peek());
    if (val < lower || val > upper) {
      return null;
    }
    queue.poll();
    TreeNode node = new TreeNode(val);
    node.left = helper(queue, lower, val);
    node.right = helper(queue, val, upper);

    return node;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;