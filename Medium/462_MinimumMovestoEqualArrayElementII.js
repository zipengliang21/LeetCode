/**
 * @param {number[]} nums
 * @return {number}
 */
const minMoves2 = (nums) => {
    nums.sort((a, b) => a - b);
    const median = nums[Math.floor(nums.length / 2)];

    let result = 0;
    for (const current of nums) {
        result += Math.abs(current - median);
    }

    return result;
};