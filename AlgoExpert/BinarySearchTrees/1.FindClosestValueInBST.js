/**
 * My Solution
 * @param {*} tree 
 * @param {*} target 
 */
function findClosestValueInBst(tree, target) {
    // Write your code here.
    let closestMin = Number.MIN_SAFE_INTEGER;
    let closestMax = Number.MAX_SAFE_INTEGER;
    while (tree !== null) {
        if (tree.value === target) return target;
        else if (tree.value < target) {
            closestMin = tree.value;
            tree = tree.right;
        } else if (tree.value > target) {
            closestMax = tree.value;
            tree = tree.left
        }
    }
    return target - closestMin < closestMax - target ? closestMin : closestMax;
}

/**
 * Similar Reference Solution
 * @param {*} tree
 * @param {*} target
 */
function findClosestValueInBst(tree, target) {
    return findClosestValueInBstHelper(tree, target, tree.value);
}

function findClosestValueInBstHelper(tree, target, closest) {
    let currentNode = tree;
    while (currentNode !== null) {
        if (Math.abs(target - closest) > Math.abs(target - currentNode.value)) {
            closest = currentNode.value;
        }
        else if (target < currentNode.value) {
            currentNode = currentNode.left;
        } else if (target > currentNode.value) {
            currentNode = currentNode.right;
        } else {
            break;
        }
    }
    return closest;
}



