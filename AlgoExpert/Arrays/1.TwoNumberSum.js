/**
 * My Solution 1
 * @param {*} array The given array
 * @param {*} targetSum The target value
 */
let twoNumberSum = (array, targetSum) => {
    // Write your code here.
    for (let i = 0; i < array.length - 1; i++) {
        for (let j = i + 1; j < array.length; j++) {
            if (array[i] + array[j] === targetSum) {
                return [array[i], array[j]];
            }
        }
    }
    return [];
}

/**
 * My Solution 2
 * @param {*} array  The given array
 * @param {*} targetSum  The target value
 */
let twoNumberSum = function (nums, target) {
    let hashTable = new Map();
    for (let i = 0; i < nums.length; i++) {
        hashTable.set(nums[i], i);
    }
    for (let i = 0; i < nums.length; i++) {
        let complement = target - nums[i];
        if (hashTable.get(complement) && hashTable.get(complement) !== i) {
            return [nums[i], complement];
        }
    }
    return [];
};

/**
 * My Solution 3
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 * One-Pass Hash Table
 */
let twoNumberSum = function (nums, target) {
    let hashTable = new Map();
    for (let i = 0; i < nums.length; i++) {
        let complement = target - nums[i];
        if (hashTable.get(complement) !== undefined) {
            return [nums[i], complement];
        }
        hashTable.set(nums[i], i);
    }
    return [];
};

