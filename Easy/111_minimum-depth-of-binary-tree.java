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
// BFS
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int result = 0;
        
        // step 1: construct a queue
        Queue<TreeNode> queue = new LinkedList<>();
        
        // step 2: add the root into queue
        queue.add(root);
        
        // step 3: while loop to check whether queue is empty, then BFS
        // if empty, means traversal is done
        while (!queue.isEmpty()) {
            // get the number of element in each level, and then traversal
            int size = queue.size();
            result++;

            // do traversal in each level
            for (int i = 0; i < size; i++) {
                // poll, find current node's child/children node
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return result;
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
        }
        
        return result;
    }
}

// DFS
class Solution {
    private int minDepth = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root, 1);
        return minDepth;
    }

    private void helper(TreeNode root, int currentDepth) {
        if (root == null) {
            return;
        }

        // only update the minDepth in the left node and currentDepth < minDepth
        if (root.left == null && root.right == null && currentDepth < minDepth) {
            minDepth = currentDepth;
        }

        helper(root.left, currentDepth + 1);
        helper(root.right, currentDepth + 1);
    }
}