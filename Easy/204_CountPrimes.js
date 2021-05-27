/**
 * @param {number} n
 * @return {number}
 */
const countPrimes = function (n) {
    let count = 0;
    for (let i = 2; i < n; i++) {
        if (isPrimes(i)) count++;
    }

    return count;
};

const isPrimes = (n) => {
    const m = Math.pow(n, 0.5);

    if (n === 0 || n === 1) return false;

    for (let i = 2; i <= m; i++) {
        if (n % i === 0) return false;
    }

    return true;
}