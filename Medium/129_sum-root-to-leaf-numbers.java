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
    public int sumNumbers(TreeNode root) {
        List<String> result = new ArrayList<>();

        // if (root == null) {
        // return result;
        // }

        StringBuffer sb = new StringBuffer();
        helper(result, sb, root);

        int sum = 0;
        for (String num : result) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }

    private void helper(List<String> result, StringBuffer sb, TreeNode root) {
        sb.append(root.val);

        // when should we terminate recursion
        // && when should we add the unique solution to result
        if (root.left == null && root.right == null) {
            result.add(sb.toString());
            return;
        }

        if (root.left != null) {
            helper(result, sb, root.left);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (root.right != null) {
            helper(result, sb, root.right);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}