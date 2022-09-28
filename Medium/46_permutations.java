class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // result set
        List<List<Integer>> result = new ArrayList<>();
        
        // check input
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        // each solution
        List<Integer> list = new ArrayList<>();
        
        // calculate the result set: put each solution into result
        helper(result, list, nums);
        
        return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> list, int[] nums) {
        // 1. when should we terminate the recursion? && 2. important - when should we put each solution into the result list
        // deep copy
        if (list.size() == nums.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        // 3. divide into subproblem (pruning?) 
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);

            helper(result, list, nums);
            // backtracking: remove the last element
            list.remove(list.size() - 1);
        }
    }
}