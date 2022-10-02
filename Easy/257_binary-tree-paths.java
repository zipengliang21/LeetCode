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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();

        // if (root == null) {
        // return result;
        // }

        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        helper(result, list, root);

        return result;
    }

    private void helper(List<String> result, List<Integer> list, TreeNode root) {
        // when should we terminate recursion
        if (root == null) {
            return;
        }

        // && when should we add the unique solution to result
        if (root.left == null && root.right == null) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < list.size() - 1; i++) {
                sb.append(list.get(i)).append("->");
            }
            sb.append(list.get(list.size() - 1));
            result.add(sb.toString());
            return;
        }

        if (root.left != null) {
            list.add(root.left.val);
            helper(result, list, root.left);
            list.remove(list.size() - 1);
        }

        if (root.right != null) {
            list.add(root.right.val);
            helper(result, list, root.right);
            list.remove(list.size() - 1);
        }
    }
}