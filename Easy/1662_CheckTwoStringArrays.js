/**
 * @param {string[]} word1
 * @param {string[]} word2
 * @return {boolean}
 */
const arrayStringsAreEqual = function (word1, word2) {
    let first = "";
    let second = "";
    for (const word of word1) {
        first += word;
    }
    for (const word of word2) {
        second += word;
    }

    return first === second;
};