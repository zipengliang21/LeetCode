/**
 * @param {string} s
 * @return {boolean}
 */
const isValid = (s) => {
    let stack = [];
    for (const bracket of s) {
        if (bracket === "(") {
            stack.push("(");
        } else if (bracket === "{") {
            stack.push("{");
        } else if (bracket === "[") {
            stack.push("[");
        } else if (bracket === ")") {
            const element = stack.pop();
            if (element !== "(") {
                return false;
            }
        } else if (bracket === "}") {
            const element = stack.pop();
            if (element !== "{") {
                return false;
            }
        } else if (bracket === "]") {
            const element = stack.pop();
            if (element !== "[") {
                return false;
            }
        }
    }
    return stack.length === 0;
};