/**
 * @param {string} s
 * @return {number}
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 */
let calculate = function (s) {
    if (s === null || s.length === 0) return 0;

    let newS = "";
    for (const c of s) {
        if (c !== " ") {
            newS += c;
        }
    }
    let result = 0;
    let temp = 0;
    let operator;
    for (let i = 0; i < newS; i++) {
        //Not Done yet
    }
};