/**
 * @param {number} x
 * @return {boolean}
 */
const isPalindrome = (x) => {
    if (x < 0) return false;
    let xString = x.toString();
    for (let i = 0; i < parseInt(xString.length / 2); i++) {
        if (xString[i] !== xString[xString.length - 1 - i]) {
            return false;
        }
    }
    return true;
};