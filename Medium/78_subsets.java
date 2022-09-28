class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // result set
        List<List<Integer>> result = new ArrayList<>();

        // check input
        if (nums == null || nums.length == 0) {
            return result;
        }

        // each solution
        List<Integer> list = new ArrayList<>();

        // sort
        // Arrays.sort(nums);

        // calculate the result set: put each solution into result
        helper(result, list, nums, 0);

        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, int[] nums, int pos) {
        // 1. when should we terminate the recursion?

        // 2. important - when should we put each solution into the result list
        // deep copy
        result.add(new ArrayList<Integer>(list));

        // 3. divide into subproblem (pruning?)
        for (int i = pos; i < nums.length; i++) {
            // 3.1 add nums[i] into current solution
            list.add(nums[i]);
            // 3.2 recursively calculate the solution ended with nums[i]
            helper(result, list, nums, i + 1);
            // 3.3 backtracking: remove the last element
            list.remove(list.size() - 1);
        }
    }
}