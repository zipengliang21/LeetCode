/**
 * @param {number[]} A
 * @param {number} K
 * @return {number}
 */
let smallestRangeII = function (A, K) {
    if (A.length === 1) {
        return 0;
    }
    A = A.sort((a, b) => a - b);
    let result = A[A.length - 1] - A[0];
    for (let i = 0; i < A.length; i++) {
        const min = A[0] + K <= A[i + 1] - K ? A[0] + K : A[i + 1] - K;
        const max = A[i] + K >= A[A.length - 1] - K ? A[i] + K : A[A.length - 1] - K;
        result = max - min <= result ? max - min : result;
    }
    return result;
};