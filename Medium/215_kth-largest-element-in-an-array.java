class Solution {
    public int findKthLargest(int[] nums, int k) {
        int pivot = nums.length - k + 1;
        return quickSelect(0, nums.length - 1, pivot, nums);
    }

    private int quickSelect(int start, int end, int k, int[] nums) {
        // base case
        if (start == end) {
            return nums[start];
        }
        int index = partition(nums, start, end);

        // including nums[index]
        int num = index - start + 1;
        if (k == num) {
            return nums[index];
        } else if (k < num) {
            return quickSelect(start, index - 1, k, nums);
        } else {
            return quickSelect(index + 1, end, k - num, nums);
        }
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = start; // pivot = end;
        int value = nums[pivot];

        while (start < end) {
            while (start < end && nums[end] >= value) {
                end--;
            }

            // Find the element that smaller than value;
            // nums[start] = nums[end];
            swap(nums, start, end);

            while (start < end && nums[start] <= value) {
                start++;
            }

            // Find the element that smaller than value;
            // nums[end] = nums[start];
            swap(nums, end, start);
        }
        // nums[start] = value;
        return start;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}