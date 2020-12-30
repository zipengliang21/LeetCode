/**
 * @param {number[]} nums
 * @return {number}
 * The following way is DP with O(n) Time and O(n) Space
 */
let maxSubArray = function (nums) {
    let dp = new Array(nums.length);
    dp[0] = nums[0];
    let max = dp[0];
    for (let i = 1; i < nums.length; i++) {
        dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        max = Math.max(max, dp[i]);
    }
    return max;
};

/**
 * @param {number[]} nums
 * @return {number}
 * This is called Kadane's Algorithm.
 * It's DP with O(n) Time and O(1) Space
 */
let maxSubArray = function (nums) {
    let current = nums[0];
    let max = nums[0];
    for (let i = 1; i < nums.length; i++) {
        current = Math.max(current + nums[i], nums[i]);
        max = Math.max(max, current);
    }
    return max;
};