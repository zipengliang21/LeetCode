class Solution {

    private Map<Character, char[]> digitsToChars = new HashMap<Character, char[]>() {
        {
            put('2', new char[] { 'a', 'b', 'c' });
            put('3', new char[] { 'd', 'e', 'f' });
            put('4', new char[] { 'g', 'h', 'i' });
            put('5', new char[] { 'j', 'k', 'l' });
            put('6', new char[] { 'm', 'n', 'o' });
            put('7', new char[] { 'p', 'q', 'r', 's' });
            put('8', new char[] { 't', 'u', 'v' });
            put('9', new char[] { 'w', 'x', 'y', 'z' });
        }
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        // each solution
        StringBuffer sb = new StringBuffer();

        helper(result, sb, digits);

        return result;
    }

    private void helper(List<String> result, StringBuffer sb, String digits) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }

        for (char ch : digitsToChars.get(digits.charAt(sb.length()))) {
            sb.append(ch);
            helper(result, sb, digits);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}