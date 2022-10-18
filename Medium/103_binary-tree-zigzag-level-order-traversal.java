/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        boolean isLeftToRight = true;
        
        // step 1: construct a queue
        Queue<TreeNode> queue = new LinkedList<>();
        
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
                TreeNode node = queue.poll();
                // record current value
                if (isLeftToRight) {
                    levelList.add(node.val);
                } else {
                    levelList.add(0, node.val);
                }
                
                // left subtree
                if (node.left != null) {
                    queue.add(node.left);                   
                }
                // right subtree
                if (node.right != null) {
                    queue.add(node.right);                   
                }
            }
            
            // traversal ends in each level -add it into result
            result.add(levelList);
            isLeftToRight = !isLeftToRight;
        }
        
        // for (int i = 0; i < result.size(); i++) {
        //     if (i % 2 != 0) {
        //         List<Integer> list = result.get(i);
        //         Collections.reverse(list);
        //     }
        // }
        
        return result;
    }
}