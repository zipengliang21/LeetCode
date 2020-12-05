/**
 * @param {number} n
 * @param {number} k
 * @return {number}
 * This following is a really inefficient way!!
 */
let kthFactor = function (n, k) {
    let factors = getAllFactors(n);
    console.log(factors);
    return k > factors.length ? -1 : factors[k - 1];
};

let getAllFactors = (n) => {
    let cur = n;
    let result = [];
    result.push(1);
    if (!result.includes(cur)) {
        result.push(cur);
    }

    let divisors = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29];
    for (const divisor of divisors) {
        while (cur % divisor === 0) {
            cur = cur / divisor;
            if (!result.includes(cur)) {
                result.push(cur);
            }

            const curDivisor = n / cur;
            if (!result.includes(curDivisor)) {
                result.push(curDivisor);
            }
        }
        cur = n;
    }
    result = result.sort((a, b) => a - b);
    for (let i = 1; i < result.length / 2; i++) {
        for (let j = result.length - 1; j >= result.length / 2; j--) {
            if (result[j] % result[i] === 0 && !result.includes(result[j] / result[i])) {
                result.push(result[j] / result[i]);
                if (!result.includes(n / (result[j] / result[i]))) {
                    result.push(n / (result[j] / result[i]));
                }
            }
        }
    }

    return result.sort((a, b) => a - b);
};
