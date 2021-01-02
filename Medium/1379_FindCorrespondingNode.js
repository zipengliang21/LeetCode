/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} original
 * @param {TreeNode} cloned
 * @param {TreeNode} target
 * @return {TreeNode}
 * My solution
 */
let result = null;

const getTargetCopy = (original, cloned, target) => {
    traversal(original, cloned, target);
    return result;
};

const traversal = (original, cloned, target) => {
    if (original === null) return;
    if (original === target) {
        result = cloned;
    }
    traversal(original.left, cloned.left, target);
    traversal(original.right, cloned.right, target);
}

//--------------------------------------------------------
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} original
 * @param {TreeNode} cloned
 * @param {TreeNode} target
 * @return {TreeNode}
 * Reference Solution 1: DFS With Recursive In order Traversal
 */
let result = null;
let target = null;

const getTargetCopy = (original, cloned, target) => {
    this.target = target;
    traversal(original, cloned, target);
    return result;
};

const traversal = (original, cloned) => {
    if (original === null) return;
    traversal(original.left, cloned.left);
    if (original === this.target) {
        result = cloned;
    }
    traversal(original.right, cloned.right)
}