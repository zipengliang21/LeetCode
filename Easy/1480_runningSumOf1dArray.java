class Solution {
    public int[] runningSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int[] prefixSum = new int[nums.length]; // O(n)

        for (int i = 0; i < nums.length; i++) {
            prefixSum[i] = i == 0 ? nums[0] : (prefixSum[i - 1] + nums[i]);
        }
        return prefixSum;
    }
}