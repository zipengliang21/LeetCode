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
 * @return {string[]}
 */
const binaryTreePaths = (root) => {
    let result = [];
    addPaths(root, result, "" + root.val);
    return result;
};

const addPaths = (node, result, path) => {
    if (!node.left && !node.right) {
        result.push(path);
        return;
    }

    if (node.left) addPaths(node.left, result, path + "->" + node.left.val);
    if (node.right) addPaths(node.right, result, path + "->" + node.right.val);
}