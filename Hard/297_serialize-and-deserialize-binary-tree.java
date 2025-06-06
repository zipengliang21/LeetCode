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
      return "#";
    }
    return root.val + "," + serialize(root.left) + "," + serialize(root.right);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
    return helper(queue);

  }

  private TreeNode helper(Queue<String> queue) {
    String value = queue.poll();
    if (value.equals("#")) {
      return null;
    }
    TreeNode root = new TreeNode(Integer.valueOf(value));
    root.left = helper(queue);
    root.right = helper(queue);

    return root;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));