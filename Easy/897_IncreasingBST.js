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
 * @return {TreeNode}
 */
let increasingBST = function (root) {
    let result = [];
    storeInOrder(root, result);
    let output = new TreeNode(0);
    let pointer = output;
    for (const value of result) {
        pointer.right = new TreeNode(value);
        pointer = pointer.right;
    }
    return output.right;
};

let storeInOrder = (node, result) => {
    if (node === null) {
        return;
    }
    storeInOrder(node.left, result);
    result.push(node.val);
    storeInOrder(node.right, result);
}