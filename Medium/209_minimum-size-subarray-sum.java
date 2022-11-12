class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int sum = 0;

        int i = 0;
        int j = 0;

        for (i = 0; i < nums.length; i++) {
            while (j < nums.length && sum < target) {
                sum += nums[j];
                j++;
            }

            if (sum >= target) {
                result = Math.min(result, j - i);
            }
            sum -= nums[i];
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }
}