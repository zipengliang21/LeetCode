package Easy;

class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        if (s.length() % 2 != 0) {
            return false;
        }

        // left parenthese stack
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (isLeftParenthese(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    // the number of right parenthese is larger than the left one
                    return false;
                }
                char left = stack.pop();
                if (!isMatch(left, ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isLeftParenthese(char c) {
        return (c == '(') || (c == '{') || (c == '[');
    }

    private boolean isMatch(char left, char right) {
        if (left == '(') {
            return right == ')';
        } else if (left == '{') {
            return right == '}';
        } else if (left == '[') {
            return right == ']';
        } else {
            return false;
        }
    }
}
