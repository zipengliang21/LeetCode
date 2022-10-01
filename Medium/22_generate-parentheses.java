class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        // unique solution string: length = 2 * n
        char[] ch = new char[2 * n];

        helper(result, ch, n, n, 0);

        return result;
    }

    private void helper(List<String> result, char[] ch, int leftRemain, int rightRemain, int index) {
        if (index == ch.length) { // leftRemain == rightRemain == 0
            result.add(new String(ch));
            return;
        }

        // divide into subproblem && pruning

        // determine when could we put left bracket -> if leftRemain > 0 -> record new leftRemain
        if (leftRemain > 0) {
            // put left bracket
            ch[index] = '(';
            helper(result, ch, leftRemain - 1, rightRemain, index + 1);
        }

        if (rightRemain > leftRemain) {
            ch[index] = ')';
            helper(result, ch, leftRemain, rightRemain - 1, index + 1);
        }
    }
}