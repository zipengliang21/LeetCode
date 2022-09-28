class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        // result set
        List<List<Integer>> result = new ArrayList<>();
        
        // check input
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        // sorting
        Arrays.sort(nums);
        
        // each solution
        List<Integer> list = new ArrayList<>();
        
        // if has been visited, set it to be true
        boolean[] visited = new boolean[nums.length];
        
        // calculate the result set: put each solution into result
        helper(result, list, nums, visited);
        
        return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] visited) {
        // 1. when should we terminate the recursion? && 2. important - when should we put each solution into the result list
        // deep copy
        if (list.size() == nums.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        // 3. divide into subproblem (pruning?) 
        for (int i = 0; i < nums.length; i++) {
            // 4. pruning
            if ((visited[i]) || (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            helper(result, list, nums, visited);
            // 5. backtracking: remove the last element
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}