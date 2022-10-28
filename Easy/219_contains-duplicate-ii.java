class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        // key: the value of the element; value: its index
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            if (map.containsKey(currentNum) && i - map.get(currentNum) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        
        return false;
    }
}