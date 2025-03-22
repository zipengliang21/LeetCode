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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        // 记录node的col位置，以及每行column的node
        Map<Integer, List<Integer>> colToNode = new HashMap<>();
        Map<TreeNode, Integer> colPosition = new HashMap<>(); 

        // 通过queue来辅助遍历，min在这里代表最左边的边界
        Queue<TreeNode> queue = new LinkedList<>();
        int min = 0;

        if (root != null) {
            queue.offer(root);
            colPosition.put(root, 0);
        }

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            int col = colPosition.get(cur);
            if (!colToNode.containsKey(col)) {
                colToNode.put(col, new ArrayList<>());
            }
            colToNode.get(col).add(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
                colPosition.put(cur.left, col - 1);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                colPosition.put(cur.right, col + 1);
            }

            min = Math.min(min, col);
        }

        // 因为我们记录了最左边的边界，从左往右一行一行加入到result
        while (colToNode.containsKey(min)) {
            result.add(colToNode.get(min++));
        }

        return result;
    }
}