/**
 * @param {number[]} nums
 * @param {number} n
 * @return {number[]}
 */
const shuffle = (nums, n) => {
    for (let i = n; i < 2 * n; i++) {
        // const temp = nums.splice(i, 1)[0];
        // nums.splice(2 * (i - n) + 1, 0, temp);
        nums.splice(2 * (i - n) + 1, 0, nums.splice(i, 1)[0]);
    }
    return nums;
};


/**
 * @param {number[]} nums
 * @param {number} n
 * @return {number[]}
 */
const shuffle = (nums, n) => {
    let res = [];
    for (i = 0; i < n; i++) {
        res.push(nums[i], nums[i + n]);
    }
    return res;
};