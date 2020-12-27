/**
 * @param {number} n
 * @return {number}
 * The following is modified from a good solution in discussion section
 */
let nextGreaterElement = (n) => {
    const num = n.toString();
    const result = nextPermutation(num);
    return (result === -1 || result > Math.pow(2, 31) - 1) ? -1 : result;
};

let nextPermutation = (nums) => {
    let i = nums.length - 1;
    while (i > 0 && nums[i - 1] >= nums[i]) i--;
    if (i === 0) return -1;

    let j = nums.length - 1;
    while (j > 0 && nums[j] <= nums[i - 1]) j--;
    let result = nums.split("");
    let temp = result[i - 1];
    result[i - 1] = result[j];
    result[j] = temp;
    result = result.splice(0, i).concat(result.reverse());
    console.log(result);
    return parseInt(result.join(""));
}