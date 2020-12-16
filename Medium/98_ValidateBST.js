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
 */
let isValidBST = (root) => {
    return validateBST(root, Number.MIN_SAFE_INTEGER, Number.MAX_SAFE_INTEGER);
};

let validateBST = (root, min, max) => {
    if (!root) { return true; }
    if (root.left && (root.left.val >= root.val || root.left.val <= min)) {
        return false;
    }
    if (root.right && (root.right.val <= root.val || root.right.val >= max)) {
        return false;
    }
    return validateBST(root.left, min, root.val) && validateBST(root.right, root.val, max);
}

// --------------------------------------------------------------------
// Similar Way

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
 */
let isValidBST = (root) => {
    return validateBST(root, Number.MIN_SAFE_INTEGER, Number.MAX_SAFE_INTEGER);
};

let validateBST = (root, min, max) => {
    if (root.val <= min || root.val >= max) {
        return false;
    }
    if (root.left && !validateBST(root.left, min, root.val)) {
        return false;
    }
    if (root.right && !validateBST(root.right, root.val, max)) {
        return false;
    }
    return true;
}