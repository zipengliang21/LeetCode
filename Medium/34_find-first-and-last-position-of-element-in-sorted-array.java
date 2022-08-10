package Medium;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null || nums.length == 0) {
            result[0] = result[1] = -1;
            return result;
        }

        // Search left bound
        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                end = mid;
            } else if (target > nums[mid]) {
                start = mid;
            } else {
                // target < nums[mid];
                end = mid;
            }
        }

        if (nums[start] == target) {
            result[0] = start;
        } else if (nums[end] == target) {
            result[0] = end;
        } else {
            result[0] = result[1] = -1;
        }

        // Search right bound
        start = 0;
        end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                start = mid;
            } else if (target > nums[mid]) {
                start = mid;
            } else {
                // target < nums[mid];
                end = mid;
            }
        }

        if (nums[end] == target) {
            result[1] = end;
        } else if (nums[start] == target) {
            result[1] = start;
        } else {
            result[0] = result[1] = -1;
        }

        return result;
    }
}
