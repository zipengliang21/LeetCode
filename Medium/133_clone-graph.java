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

// bfs
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        } 
        
        // key: original node //value: clone's node
        Map<Node, Node> map = new HashMap<>();
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        Node cloneNode = new Node(node.val);
        map.put(node, cloneNode);
        
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            
            for (Node neighborNode: curNode.neighbors) {
                // clone node precondition: neightbor node is not in the map
                if (!map.containsKey(neighborNode)) {
                    Node cloneNeighborNode = new Node(neighborNode.val);
                    map.put(neighborNode, cloneNeighborNode);
                    queue.offer(neighborNode);
                }
                
                // clone edge regardless whether the node has been visited
                Node cloneCurNode = map.get(curNode);
                List<Node> neighborsOfCloneCurNode = cloneCurNode.neighbors;
                Node cloneNeighborNode = map.get(neighborNode);
                neighborsOfCloneCurNode.add(cloneNeighborNode);
            }
        }
        
        return cloneNode;
    }
}

// dfs
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