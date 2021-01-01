/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 * Brute-Force way. Two nested for loop
 */
let twoSum = function (nums, target) {
    for (let i = 0; i < nums.length - 1; i++) {
        for (let j = i + 1; j < nums.length; j++) {
            if (nums[i] + nums[j] === target) {
                return [i, j];
            }
        }
    }
};

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 * Two-Pass Hash Table
 */
let twoSum = function (nums, target) {
    let hashTable = new Map();
    for (let i = 0; i < nums.length; i++) {
        hashTable.set(nums[i], i);
    }
    for (let i = 0; i < nums.length; i++) {
        let complement = target - nums[i];
        if (hashTable.get(complement) && hashTable.get(complement) !== i) {
            return [i, hashTable.get(complement)];
        }
    }
};

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 * One-Pass Hash Table
 */
let twoSum = function (nums, target) {
    let hashTable = new Map();
    for (let i = 0; i < nums.length; i++) {
        let complement = target - nums[i];
        if (hashTable.get(complement) !== undefined) {
            return [i, hashTable.get(complement)];
        }
        hashTable.set(nums[i], i);
    }
};

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 * NOTE: if the question is asking the values of two numbers instead of the indexes
 * Sort first and two pointer
 */
let twoSum = function (nums, target) {
    nums.sort((a, b) => a - b);
    let left = 0;
    let right = nums.length - 1;;
    while (left < right) {
        const currentSum = nums[left] + nums[right];
        if (currentSum === target) {
            return [left, right];
        } else if (currentSum < target) {
            left++;
        } else if (currentSum > target) {
            right--;
        }
    }
};

let isValidSubsequence = (array, sequence) => {
    // Write your code here.
    let indexA = 0;
    let indexS = 0;
    while (indexA < array.length) {
        if (array[indexA] === sequence[indexS]) {
            indexS++;
            if (indexS === sequence.length) return true;
        }
        indexA++;
    }
    return false;
}

