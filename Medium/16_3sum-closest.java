class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            // avoid duplication
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == target) {
                    return target;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }

                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
            }
        }

        return result;
    }
}