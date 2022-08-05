class Solution {
    public void reverseString(char[] s) {
        if(s == null || s.length == 0) {
            return;
        }

        int start = 0;
        int end = s.length - 1;
        while(start < end) {
            swap(s, start++, end--);
        }
    }

    private void swap(char[] s, int first, int second) {
        char temp = s[first];
        s[first] = s[second];
        s[second] = temp;
    }
}