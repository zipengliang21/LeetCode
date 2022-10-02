class Solution {
    private boolean[][] isPalindrome; // record whether substring from i to j is palindrome

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        calculateIsPalindrome(s);
        List<String> list = new ArrayList<>();
        Map<Integer, List<List<String>>> memo = new HashMap<>(); // key: pos index; value: the partition solution

        return helper(memo, list, s, 0);
    }

    private List<List<String>> helper(Map<Integer, List<List<String>>> memo, List<String> list, String s, int pos) {
        // when should we terminate recursion
        // && when should we add the unique solution to result
        if (pos == s.length()) {
            // deep copy
            List<List<String>> result = new ArrayList<>();
            result.add(new ArrayList<>(list));
            return result;
        }

        if (memo.containsKey(pos)) {
            return memo.get(pos);
        }

        List<List<String>> result = new ArrayList<>();
        memo.put(pos, result);

        // divide into subproblem
        for (int i = pos; i < s.length(); i++) {
            String subString = s.substring(pos, i + 1);

            if (!isPalindrome[pos][i]) {
                continue;
            }

            List<List<String>> next = helper(memo, list, s, i + 1);

            for (List<String> item : next) { // next: b bb bbb
                List<String> singleResult = new ArrayList<>();
                singleResult.add(subString); // a
                singleResult.addAll(item); // single result： a/b a/bb, a/bbb
                memo.get(pos).add(singleResult);
            }
        }

        return memo.get(pos);
    }

    // memorization
    private void calculateIsPalindrome(String s) {
        isPalindrome = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }

        for (int i = s.length() - 3; i >= 0; i--) {
            for (int j = i + 2; j < s.length(); j++) {
                isPalindrome[i][j] = (isPalindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j));
            }
        }
    }
}