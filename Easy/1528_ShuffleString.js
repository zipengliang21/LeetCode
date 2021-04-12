/**
 * @param {string} s
 * @param {number[]} indices
 * @return {string}
 */
const restoreString = (s, indices) => {
    let result = "";
    let map = {};
    for (let i = 0; i < s.length; i++)
        map[indices[i]] = s[i];

    for (let i = 0; i < s.length; i++)
        result += map[i]

    return result;
};

//------------------------------------------

/**
 * @param {string} s
 * @param {number[]} indices
 * @return {string}
 */
const restoreString = (s, indices) => {
    const len = indices.length;
    const str = new Array(len);
    for (let i = 0; i < len; i++) {
        str[indices[i]] = s[i];
    }
    return str.join("");
};
