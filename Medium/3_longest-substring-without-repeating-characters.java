class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        Set<Character> set = new HashSet<>();

        int i = 0;
        int j = 0;

        for (i = 0; i < s.length(); i++) {
            while (j < s.length()) {
                char ch = s.charAt(j);
                if (!set.contains(ch)) {
                    set.add(ch);
                    result = Math.max(result, j - i + 1);
                    j++;
                } else {
                    break;
                }
            }
            set.remove(s.charAt(i));
        }
        return result;
    }
}