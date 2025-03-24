/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Codec {
  // Encodes a tree to a single string.
  public String serialize(Node root) {
    List<String> list = new ArrayList<>();
    dfs(root, list);

    return String.join(",", list);
  }

  private void dfs(Node root, List<String> list) {
    if (root == null) {
      return;
    }
    list.add(String.valueOf(root.val));
    int n = root.children.size();
    list.add(String.valueOf(n));

    for (int i = 0; i < n; i++) {
      dfs(root.children.get(i), list);
    }
  }

  // Decodes your encoded data to tree.
  public Node deserialize(String data) {
    if (data == null || data.equals("")) {
      return null;
    }

    Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
    return helper(queue);
  }

  private Node helper(Queue<String> queue) {
    Node root = new Node(Integer.valueOf(queue.poll()), new ArrayList<>());
    int n = Integer.valueOf(queue.poll());

    for (int i = 0; i < n; i++) {
      root.children.add(helper(queue));
    }

    return root;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));