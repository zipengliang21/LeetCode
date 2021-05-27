/**
 * @param {number[]} nums
 * @return {number[][]}
 */

const subsetsWithDup = (nums) => {
    let result = [[]];

    nums.sort((a, b) => a - b);

    function backtrack(first, current) {
        // we iterate over the indexes i from 'first' to the length
        //of the entire sequence 'nums'
        for (let i = first; i < nums.length; i++) {
            if (i !== first && nums[i - 1] === nums[i]) continue;
            current.push(nums[i]);

            // use distructure operator to clone 'current' value and save to 'result'
            result.push([...current]);

            // generate all other subsets for the current subset.
            // increasing the position by one to avoid duplicates in 'result'
            backtrack(i + 1, current);

            // BACKTRACK.
            current.pop();
        }
    }

    backtrack(0, []);
    return result
};
