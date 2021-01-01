/**
 * @param {number} x
 * @return {boolean}
 * Converting to string first
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

/**
 * @param {number} x
 * @return {boolean}
 * Without converting to string
 */
const isPalindrome = (x) => {
    // When x < 0, x is not a palindrome
    // Also, if the last digit of the number is 0, in order to be a palindrome,
    // the first digit of the number also needs to be 0.
    // Only 0 satisfy this property.
    if (x < 0 || (x % 10 === 0 && x !== 0)) return false;
    let revertedNumber = 0;
    while (x > revertedNumber) {
        revertedNumber = revertedNumber * 10 + x % 10;
        x = parseInt(x / 10);
    }

    // Two cases: if the x.length is even or odd
    return x == revertedNumber || x == parseInt(revertedNumber / 10);
};

