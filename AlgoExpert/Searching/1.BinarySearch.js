/**
 * Iterative
 * @param {*} array 
 * @param {*} target 
 */
const binarySearch = (array, target) => {
    // Write your code here.
    let left = 0;
    let right = array.length - 1;
    let mid = -1;
    while (left <= right) {
        mid = parseInt((left + right) / 2);
        if (array[mid] === target) return mid;
        else if (array[mid] < target) {
            left = mid + 1;
        } else if (array[mid] > target) {
            right = mid - 1;
        }
    }
    return -1;
}

/**
 * Recursion
 * @param {*} array 
 * @param {*} target 
 */
const binarySearch = (array, target) => {
    // Write your code here.
    return binarySearchHelper(array, target, 0, array.length - 1);
}

const binarySearchHelper = (array, target, left, right) => {
    if (left > right) return -1;
    const mid = parseInt((left + right) / 2);
    const potentialMatch = array[mid];
    if (potentialMatch === target) return mid;
    else if (potentialMatch < target) {
        return binarySearchHelper(array, target, mid + 1, right);
    } else if (potentialMatch > target) {
        return binarySearchHelper(array, target, left, mid - 1);
    }
}

