/**
 * @param {number[]} instructions
 * @return {number}
 * Brute Force Way
 */
const createSortedArray = (instructions) => {
    let nums = [];
    let costs = 0;
    for (const value of instructions) {
        costs += Math.min(findLessCost(nums, value), findGreaterCost(nums, value));
        nums.push(value);
        nums.sort((a, b) => a - b);
    }
    return costs % (Math.pow(10, 9) + 7);
};

const findLessCost = (nums, value) => {
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] >= value) {
            return i;
        }
    }
    return nums.length;
}

const findGreaterCost = (nums, value) => {
    for (let i = nums.length - 1; i >= 0; i--) {
        if (nums[i] <= value) {
            return nums.length - 1 - i;
        }
    }
    return nums.length;
}

//------------------------------------------------------
/**
 * @param {number[]} instructions
 * @return {number}
 * Brute Force Way
 */
const createSortedArray = (instructions) => {
    let nums = [];
    let costs = 0;
    for (const value of instructions) {
        const index = getIndex(nums, value);
        costs += Math.min(index.less, index.more);
        console.log(costs);
        nums.splice(index.less, 0, value);
    }
    return costs % (Math.pow(10, 9) + 7);
};

const getIndex = (nums, value) => {
    let index = {
        less: 0,
        more: 0
    };
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] < value) {
            index.less = index.less + 1;
        }
        if (nums[i] > value) {
            index.more = index.more + 1;
        }
    }
    return index;
}