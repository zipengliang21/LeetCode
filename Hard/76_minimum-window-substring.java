class Solution {
    public String minWindow(String s, String t) {
        int minLength = Integer.MAX_VALUE;
        String minStr = "";

        int i = 0;
        int j = 0;

        int[] hash = new int[128];
        for (int k = 0; k < t.length(); k++) {
            hash[t.charAt(k)]++;
        }

        for (i = 0; i < s.length(); i++) {
            while (j < s.length()) {
                if (!allFound(hash)) {
                    hash[s.charAt(j)]--;
                    j++;
                } else {
                    break;
                }
            }
            // shrink && find solution
            if (allFound(hash) && j - i < minLength) {
                minLength = j - i;
                minStr = s.substring(i, j);
            }
            hash[s.charAt(i)]++;
        }

        return minStr;
    }

    private boolean allFound(int[] hash) {
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > 0) {
                return false;
            }
        }
        return true;
    }
}
