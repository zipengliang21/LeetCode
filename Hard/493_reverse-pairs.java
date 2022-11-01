class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        return countPairs(nums, 0, nums.length - 1);
    }
    
    private int countPairs(int[] nums, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            int leftCount = countPairs(nums, start, mid);
            int rightCount = countPairs(nums, mid + 1, end);
            return leftCount + rightCount + merge(nums, start, mid, end);
        }
        return 0;
    }
    
    // calculate the reverse pairs when they merge
    private int merge(int[] nums, int start, int mid, int end) {
        int pairCount = 0;
        int leftLength = mid - start + 1;
        int rightLength = end - mid;
        
        int[] left = new int[leftLength];
        int[] right = new int[rightLength];
        
        for (int i = 0; i < leftLength; i++) {
            left[i] = nums[start + i];
        }
        
        for (int i = 0; i < rightLength; i++) {
            right[i] = nums[mid + 1 + i];
        }
        
        int i = start;
        int j = mid + 1;
        
        // calculate the number of reverse pairs of [start, end]
        // [start, mid] sort, [mid + 1, end] sort
        while (i <= mid && j <= end) {
            if (nums[i] > 2 * (long) nums[j]) {
                pairCount += mid - i + 1;
                j++;
            } else {
                i++;
            }
        }
        
        int index = start;
        
        i = 0;
        j = 0;
        
        while (i < leftLength && j < rightLength) {
            if (left[i] <= right[j]) {
                nums[index++] = left[i++];
            } else {
                nums[index++] = right[j++];
            }
        }
        
        while (i < leftLength) {
            nums[index++] = left[i++];
        }
        
        while (i < rightLength) {
            nums[index++] = right[i++];
        }
        
        return pairCount;
    }
}