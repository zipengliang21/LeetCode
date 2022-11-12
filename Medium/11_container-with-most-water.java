class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int result = 0;

        while (start < end) {
            int area = Math.min(height[start], height[end]) * (end - start);
            result = Math.max(result, area);
            if (height[end] > height[start]) {
                start++;
            } else {
                end--;
            }
        }

        return result;
    }
}