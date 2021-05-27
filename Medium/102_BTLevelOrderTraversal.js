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
 * @return {number[][]}
 */


const levelOrder = (root) => {
    const result = [];
    levelOrderTraversal(root, 0, result);
    return result;
};

const levelOrderTraversal = (node, height, result) => {
    if (!node) {
        return;
    }

    if (height === result.length) {
        result.push([node.val])
    } else {
        result[height].push(node.val)
    }

    levelOrderTraversal(node.left, height + 1, result);
    levelOrderTraversal(node.right, height + 1, result);
}