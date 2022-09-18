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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);

    }

    public TreeNode helper(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd,
            Map<Integer, Integer> map) {
        if (iStart > iEnd || pStart > pEnd) {
            return null;
        }
        // 1. find the root node from preorder
        TreeNode root = new TreeNode(preorder[pStart]);

        // 2. find the left and right tree by inorder

        // 2.1 find the root from the inorder array
        int rootPos = findRootPos(map, root.val);

        // 2.2 left subtree of inorder: [inStart, rootPos - 1], of preorder:
        int leftNodeCount = rootPos - iStart;
        root.left = helper(preorder, pStart + 1, pStart + leftNodeCount, inorder, iStart, rootPos - 1, map);

        // 2.3 right subtree of inorder: [rootPos + 1, iEnd], of preorder:
        root.right = helper(preorder, pStart + leftNodeCount + 1, pEnd, inorder, rootPos + 1, iEnd, map);

        return root;
    }

    // Use Hashmap to optimize:
    // key: inorder-value, value: i O(1) => i
    private int findRootPos(Map<Integer, Integer> map, int rootVal) {
        return map.getOrDefault(rootVal, -1);
    }

    // private int findRootPos(int[] inorder, int rootVal) {
    // for (int i = 0; i < inorder.length; i++) {
    // if (inorder[i] == rootVal) {
    // return i;
    // }
    // }
    // return -1;
    // }
}