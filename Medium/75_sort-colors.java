class Solution {
    public void sortColors(int[] nums) {
        int first = 0;
        int second = nums.length - 1;
        int i = 0;
        while (i <= second) {
            if (nums[i] == 0) {
                swap(nums, i, first);
                first++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, second);
                second--;
            } else {
                i++;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}