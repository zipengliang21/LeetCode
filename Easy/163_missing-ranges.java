class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        if (nums == null || n == 0) {
            list.add(Arrays.asList(lower, upper));
            return list;
        }

        if (lower < nums[0]) {
            list.add(Arrays.asList(lower, nums[0] - 1));
        }

        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] - nums[i] == 1) {
                continue;
            }
            list.add(Arrays.asList(nums[i] + 1, nums[i + 1] - 1));
        }

        if (upper > nums[n - 1]) {
            list.add(Arrays.asList(nums[n - 1] + 1, upper));
        }

        return list;
    }
}