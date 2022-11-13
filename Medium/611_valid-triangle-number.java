class Solution {
    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        // a + b > c
        // we pick c from the end of the array, move from end to the beginning
        for (int i = nums.length - 1; i >= 2; i--) {
            int start = 0;
            int end = i - 1;

            while (start < end) {
                int sum = nums[start] + nums[end];
                if (sum > nums[i]) {
                    count += end - start;
                    end--;
                } else {
                    start++;
                }
            }
        }

        return count;
    }
}