/**
 * @param {number[]} A
 * @param {number[]} B
 * @param {number[]} C
 * @param {number[]} D
 * @return {number}
 */
let fourSumCount = (A, B, C, D) => {
    let map = new Map();
    let result = 0;
    for (let a of A)
        for (let b of B)
            map.set(a + b, (map.get(a + b) | 0) + 1);
    for (let c of C)
        for (let d of D)
            if (map.has(-c - d))
                result += map.get(-c - d);
    return result;
};
