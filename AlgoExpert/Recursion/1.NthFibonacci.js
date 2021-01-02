/**
 * Recursion
 * @param {number} n 
 */
const getNthFib = (n) => {
    // Write your code here.
    if (n - 1 === 0) return 0;
    else if (n - 1 === 1) return 1;
    else return getNthFib(n - 1) + getNthFib(n - 2);
}