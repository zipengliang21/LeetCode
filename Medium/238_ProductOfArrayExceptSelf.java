package Medium;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int[] answer = new int[nums.length];

        answer[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        int factor = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] = answer[i] * factor;
            factor *= nums[i];
        }

        return answer;
    }
}

/**
 * if(nums == null || nums.length == 0) {
 * return null;
 * }
 * 
 * int[] answer = new int[nums.length];
 * int[] left = new int[nums.length];
 * int[] right = new int[nums.length];
 * 
 * left[0] = 1;
 * for(int i = 1; i < nums.length; i++) {
 * left[i] = nums[i - 1] * left[i - 1];
 * }
 * 
 * right[nums.length - 1] = 1;
 * for(int i = nums.length - 2; i >= 0; i--) {
 * right[i] = nums[i + 1] * right[i + 1];
 * }
 * 
 * for(int i = 0; i< nums.length; i++) {
 * answer[i] = left[i] * right[i];
 * }
 * 
 * return answer;
 * }
 */
