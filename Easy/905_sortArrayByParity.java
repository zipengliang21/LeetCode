class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start < end) {
            while(nums[start] % 2 == 0 && start < nums.length - 1) {
                start++;
            }

            while(nums[end] % 2 == 1 && end > 0 ) {
                end--;
            }

            if(start < end) {
                swap(nums, start, end);
            }
        }

        return nums;
    }

    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}

/**
        // Bruce Force:
        int[] result = new int[nums.length];
        int index = 0;
        for(int i = 0; i< nums.length;i++) {
            if(nums[i] % 2 == 0) {
                result[index++] = nums[i];
            }
        }

        for(int i = 0; i< nums.length;i++) {
            if(nums[i] % 2 == 1) {
                result[index++] = nums[i];
            }
        }

        return result;
 */