/**
 * @param {number[]} arr
 * @param {number} k
 * @return {number}
 * Brute Force way
 */
const findKthPositive = (arr, k) => {
    let result = 1;
    let missingCount = 0;
    let arrCount = 0;
    while (missingCount < k) {
        if (arr.length <= arrCount || arr[arrCount] !== result) {
            missingCount++;
        } else {
            arrCount++;
        }
        result++;
    }
    return result - 1;
};

/**
 * @param {number[]} arr
 * @param {number} k
 * @return {number}
 * Simpler Brute Force way
 */
const findKthPositive = (arr, k) => {
    let count = 1;
    while (count) {
        if (!arr.includes(count)) {
            k--;
        }
        if (k === 0) return count;
        count++;
    }
};


/**
 * @param {number[]} arr
 * @param {number} k
 * @return {number}
 * HashTable
 */
const findKthPositive = (arr, k) => {
    let table = new Map();
    let missingCount = 0;
    let result = 1;
    for (const value of arr) {
        table.set(value, value);
    }
    while (missingCount < k) {
        if (table.get(result) !== result) {
            missingCount++;
        }
        result++;
    }
    return result - 1;
};