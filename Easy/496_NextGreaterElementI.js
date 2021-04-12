/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
/**
Basically the problem says, if in nums1 we are working on 4, 
then in nums2 first find where is 4 and from that index find 
the next number greater than 4 in nums2. We can see that the solution is always 
coming from the reverse side of the list nums2. This should tell us to use stack.
 */
/**
 * 
 * 1.We traverse nums2 and start storing elements on the top of stack.
   2.If current number is greater than the top of the stack, then we found a pair. 
   Keep popping from stack till the top of stack is smaller than current number.
   3.After matching pairs are found, push current number on top of stack.
   4.Eventually when there are no more elements in nums2 to traverse, 
   but there are elements in stack, we can justify that next bigger element wasn't found for them. 
   Hence we'll put -1 for the remaining elements in stack.} nums1 
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