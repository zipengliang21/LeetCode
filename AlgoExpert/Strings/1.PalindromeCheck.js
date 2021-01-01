/**
 * @param {string} string
 * @return {boolean}
 * Two Pointer Check
 */
const isPalindrome = (string) => {
    for (let i = 0; i < parseInt(string.length / 2); i++) {
        if (string[i] !== string[string.length - 1 - i]) {
            return false;
        }
    }
    return true;
};


/**
 * @param {string} string
 * @return {boolean}
 * Reference Solution
 * O(n) time | O(1) space
 */
const isPalindrome = (string) => {
    let leftIdx = 0;
    let rightIdx = string.length - 1;
    while (leftIdx < rightIdx) {
        if (string[leftIdx] !== string[rightIdx]) { return false; }
        leftIdx++;
        rightIdx--;
    }
    return true;
};