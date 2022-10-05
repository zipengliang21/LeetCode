class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // store whether substring start with index i could be segmented into dict
        // -1: initilized value
        // 0: false
        // 1: true
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return helper(memo, s, wordDict, 0);
    }

    private boolean helper(int[] memo, String s, List<String> wordDict, int pos) {
        if (pos == s.length()) {
            return true;
        }

        if (memo[pos] != -1) {
            return memo[pos] == 1;
        }

        for (int i = s.length() - 1; i >= pos; i--) {
            String subString = s.substring(pos, i + 1);
            if (!wordDict.contains(subString)) {
                continue;
            }

            boolean result = helper(memo, s, wordDict, i + 1);

            if (result) {
                memo[pos] = 1;
                return true;
            }
        }

        memo[pos] = 0;
        return false;
    }
}