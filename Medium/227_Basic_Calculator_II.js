/**
 * @param {string} s
 * @return {number}
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 * This solution is from the Discuss Section
 */
let calculate = function (s) {
    let currentNumber = "";
    let currentOperator = null;
    let stack = [];
    for (let i = 0; i <= s.length; i++) {
        let currentChar = s[i];
        if (currentChar === " ") continue;
        if (!isNaN(currentChar)) {
            currentNumber += currentChar;
        } else if (isNaN(currentChar)) {
            currentNumber = Number(currentNumber);
            if (currentOperator === "+" || currentOperator === null) {
                stack.push(currentNumber);
            } else if (currentOperator === "-") {
                stack.push(-currentNumber);
            } else if (currentOperator === "*") {
                stack.push(stack.pop() * currentNumber);
            } else if (currentOperator === "/") {
                stack.push(parseInt(stack.pop() / currentNumber));
            }
            currentOperator = currentChar;
            currentNumber = "";
        }
    }
    //we reduce the array adding positive and negative numbers
    return stack.reduce((a, b) => {
        return a + b
    }, 0)
};
