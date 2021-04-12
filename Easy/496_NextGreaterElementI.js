/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
const nextGreaterElement = (nums1, nums2) => {
    let stack = [];
    let map = {};
    let result = [];
    stack.push(nums2[0]);

    for (let i = 1; i < nums2.length; i++) {
        while (stack.length > 0 && nums2[i] > stack[stack.length - 1]) {
            map[stack[stack.length - 1]] = nums2[i];
            stack.pop();
        }
        stack.push(nums2[i]);
    }

    for (const num of stack) {
        map[num] = -1;
    }

    for (const num of nums1) {
        result.push(map[num]);
    }

    return result;
};