/**
 * @param {number[]} nums
 * @return {number[]}
 */
let sortedSquares = function (nums) {
    if (nums.length === 0) { return nums }
    let length = nums.length;
    let indexN = length - 1;
    for (const [i, num] of nums.entries()) {
        if (num >= 0) {
            indexN = i - 1;
            break;
        } else {
            nums[i] = num * num;
        }
    }
    let map1 = nums.splice(0, indexN + 1);
    nums = nums.map(x => x * x);
    let indexP = 0;
    length = length - indexN - 1;
    let result = [];
    while (indexN >= 0 && indexP <= length - 1) {
        if (nums[indexP] >= map1[indexN]) {
            result.push(map1[indexN]);
            indexN--;
        }
        else {
            result.push(nums[indexP]);
            indexP++;
        }
    }
    while (indexN >= 0) {
        result.push(map1[indexN]);
        indexN--;
    }
    while (indexP <= length - 1) {
        result.push(nums[indexP]);
        indexP++;
    }
    return result;
};