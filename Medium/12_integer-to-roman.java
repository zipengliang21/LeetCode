class Solution {
    public String intToRoman(int num) {
        // Change the map to 2 arrays
        // 7 normal character + 6 special ones
        int[] nums = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < 13; i++) {
            while (num >= nums[i]) {
                num -= nums[i];
                sb.append(romans[i]);
            }
        }

        return sb.toString();
    }
}