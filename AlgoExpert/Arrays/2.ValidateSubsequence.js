/**
 * 
 * @param {*} array The given array
 * @param {*} sequence The sequence needs to be validated
 */
let isValidSubsequence = (array, sequence) => {
    // Write your code here.
    let indexA = 0;
    let indexS = 0;
    while (indexA < array.length) {
        if (array[indexA] === sequence[indexS]) {
            indexS++;
            if (indexS === sequence.length) return true;
        }
        indexA++;
    }
    return false;
}