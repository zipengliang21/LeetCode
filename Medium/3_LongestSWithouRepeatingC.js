/**
 * @param {string} s
 * @return {number}
 */
const lengthOfLongestSubstring = (s) => {
    let result = 0;
    for (let i = 0; i < s.length; i++) {
        for (let j = 0; j <= s.length; j++) {
            let subString = s.substring(i, j);
            if (isValidSubstring(subString) && result < subString.length) {
                result = subString.length
            }
        }
    }
    return result;
};

const isValidSubstring = (subString) => {
    let table = new Map();
    for (const c of subString) {
        if (table.get(c) !== 1) {
            table.set(c, 1);
        } else {
            return false;
        }
    }
    return true;
}

// ---------------------------------------------------
/**
 * @param {string} s
 * @return {number}
 * Sliding Window
 */
const lengthOfLongestSubstring = (s) => {
    let result = 0, right = 0;
    const visited = new Set();
    for (let left = 0; left < s.length; left++) {
        while (right < s.length && !visited.has(s[right])) {
            visited.add(s[right]);
            right++;
        }
        result = Math.max(result, right - left);
        visited.delete(s[left]);
    }
    return result;
};