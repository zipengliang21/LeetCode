class Solution {
    public int trap(int[] height) {
        // for each i, record the max in its left
        int[] h = new int[height.length];

        int result = 0;
        // from left to right
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            max = Math.max(height[i], max);
            h[i] = max;
        }

        // from right to left
        max = Integer.MIN_VALUE;
        for (int i = height.length - 1; i >= 0; i--) {
            max = Math.max(height[i], max);
            int right = max;

            int minHeight = Math.min(h[i], right);
            if (minHeight > height[i]) {
                result += minHeight - height[i];
            }
        }

        return result;
    }
}