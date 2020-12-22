/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 * My solution is straightforward.
 * Create a helper function for obtain the height of the given node.
 * Then, check whether there's AVL Tree violation for each node of the tree
 * If no, return true; otherwise, return false.
 */
let isBalanced = function (root) {
    if (!root) return true;
    else if (heightHelper(root.left, 1) > heightHelper(root.right, 1) + 1 ||
        heightHelper(root.left, 1) + 1 < heightHelper(root.right, 1)) {
        return false;
    }
    return isBalanced(root.left) && isBalanced(root.right);
};

let heightHelper = (node, height) => {
    if (!node) return height - 1;
    return Math.max(heightHelper(node.left, height), heightHelper(node.right, height)) + 1;
}