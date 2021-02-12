/**
 * pseudo-code:
 * function QuickSelect(nums[1..n], k) // returns element of rank k in nums, 1 <= k <= n
 * if n > 1 then
 *   Choose pivot element p = nums[Math.floor(nums.length / 2)] // mid value
 *   Let Lesser be an array of all elements from nums less than p
 *   Let Greater be an array of all elements from nums greater than p
 *   Let equal be the occurrence times of p
 *   if |Greater| = k - 1 or (|Greater| < k - 1 and |Greater| + equal > k - 1)
 *      return p
 *   Else if |Greater| > k - 1
 *      return QuickSelect(Greater, k)
 *   Else if |Greater| < k - 1
 *      return QuickSelect(Lesser, k - |Greater| - equal)
 * else 
 *   return nums[1]
 */


/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
const findKthLargest = function (nums, k) {
    if (nums.length > 1) {
        const pivot = nums[Math.floor(nums.length / 2)];
        let lesser = [];
        let greater = [];
        let equal = 0;
        for (const num of nums) {
            if (num < pivot) {
                lesser.push(num);
            } else if (num > pivot) {
                greater.push(num);
            } else {
                equal++;
            }
        }

        delete nums;

        if (greater.length === k - 1 ||
            (greater.length < k - 1 && greater.length + equal > k - 1)) {
            return pivot;
        } else if (greater.length > k - 1) {
            lesser = [];
            return findKthLargest(greater, k);
        } else if (greater.length < k - 1) {
            const greaterLength = greater.length;
            delete greater;
            return findKthLargest(lesser, k - greaterLength - equal);
        }
    } else {
        return nums[0];
    }
};