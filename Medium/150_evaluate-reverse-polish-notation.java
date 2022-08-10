package Medium;

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (isOperator(token)) {
                // else if it's a OP(+-*/), then pop the two poppest elements for operations
                int secondNum = stack.pop();
                int firstNum = stack.pop();
                int result = operator(firstNum, secondNum, token);
                stack.push(result);
            } else {
                // if current token is a number, then push it into the stack
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private boolean isOperator(String token) {
        return "+".equals(token)
                || "-".equals(token)
                || "*".equals(token)
                || "/".equals(token);
    }

    private int operator(int firstNum, int secondNum, String operator) {
        if ("+".equals(operator)) {
            return firstNum + secondNum;
        } else if ("-".equals(operator)) {
            return firstNum - secondNum;
        } else if ("*".equals(operator)) {
            return firstNum * secondNum;
        } else {
            return firstNum / secondNum;
        }
    }
}
