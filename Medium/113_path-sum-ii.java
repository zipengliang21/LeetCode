/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        List<Integer> list = new ArrayList<>();
        helper(result, list, root, targetSum);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, TreeNode root, int targetSum) {
        list.add(root.val);
        targetSum -= root.val;
        // when should we terminate recursion
        // && when should we add the unique solution to result
        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                // deep copy
                result.add(new ArrayList(list));
            }
            return;
        }

        if (root.left != null) {
            helper(result, list, root.left, targetSum);
            list.remove(list.size() - 1);
        }

        if (root.right != null) {
            helper(result, list, root.right, targetSum);
            list.remove(list.size() - 1);
        }
    }
}