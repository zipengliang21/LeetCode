/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        // key: original node
        // value: corresponding clone node
        Map<Node, Node> map = new HashMap<>();
        return dfs(map, node);
    }

    // clone the given node
    private Node dfs(Map<Node, Node> map, Node node) {
        if (map.containsKey(node)) {
            return map.get(node);
        }

        Node newNode = new Node(node.val);
        map.put(node, newNode);

        // get new node's adjancency list
        for (Node neighbors: node.neighbors) {
            Node newNeighbor = dfs(map, neighbors);
            newNode.neighbors.add(newNeighbor);
        }

        return newNode; 
    }
}