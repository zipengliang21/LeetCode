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

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        // step 1: construct a queue
        Queue<Node> queue = new LinkedList<>();
        
        // step 2: add the root into queue
        queue.add(root);
        
        // step 3: while loop to check whether queue is empty, then BFS
        // if empty, means traversal is done
        while (!queue.isEmpty()) {
            // get the number of element in each level, and then traversal
            int size = queue.size();
            // store elements in each level
            List<Integer> levelList = new ArrayList<>();
            // do traversal in each level
            for (int i = 0; i < size; i++) {
                // poll, find current node's child/children node
                Node node = queue.poll();
                // record current value
                levelList.add(node.val);

                for (Node childNode: node.children) {
                    queue.offer(childNode);
                }
            }
            
            // traversal ends in each level -add it into result
            result.add(levelList);
        }
        
        return result;
    }
}