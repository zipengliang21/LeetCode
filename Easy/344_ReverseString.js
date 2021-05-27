/**
 * @param {character[]} s
 * @return {void} Do not return anything, modify s in-place instead.
 */
const reverseString = function (s) {
    for (let i = 0; i < Math.floor(s.length / 2); i++) {
        const temp = s[i]
        s[i] = s[s.length - 1 - i]
        s[s.length - 1 - i] = temp
    }
    return s
};