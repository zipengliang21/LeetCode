/**
 * @param {number} n
 * @return {string[]}
 */
const fizzBuzz = (n) => {
    let current = 1;
    let result = [];
    while (current <= n) {
        if (current % 3 === 0 && current % 5 === 0) {
            result.push("FizzBuzz");
        } else if (current % 3 === 0) {
            result.push("Fizz");
        } else if (current % 5 === 0) {
            result.push("Buzz");
        } else {
            result.push(`${current}`);
        }
        current++;
    }
    return result;
};