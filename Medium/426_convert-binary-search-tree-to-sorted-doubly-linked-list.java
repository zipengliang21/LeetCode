/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Node first = null, prev = null;
        Stack<Node> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (first == null) {
                first = root;
            }
            if (prev != null) {
                prev.right = root;
                root.left = prev;
            }
            prev = root;
            root = root.right;
        }
        first.left = prev;
        prev.right = first;

        return first;
    }
}