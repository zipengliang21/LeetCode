/**
 * @param {number[]} nums
 * @return {boolean}
 * 
 * Approach: 
 * Initial i, j to infinity first;
 * Iterate the given array, 
 * If value < i, replace the new value for i; 
 * Else if i < value && value < j, replace the new value for j; 
 * Else if j < value, meaning we find the k already, return true
 * Else, ignore the value
 * After the iteration, return false, meaning we can't find the triplet. 
 */
let increasingTriplet = function (nums) {
    let i = Number.MAX_SAFE_INTEGER;
    let j = Number.MAX_SAFE_INTEGER;
    for (const value of nums) {
        if (value < i) {
            i = value;
        } else if (i < value && value < j) {
            j = value;
        } else if (j < value) {
            return true;
        }
    }
    return false;
};