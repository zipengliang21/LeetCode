class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (candidates == null || candidates.length == 0) {
            return result;
        }

        // sorting
        Arrays.sort(candidates);

        // unique solution
        List<Integer> list = new ArrayList<>();

        helper(result, list, candidates, target, 0);

        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, int[] candidates, int target, int pos) {
        // when should we exit the recursion

        // when should we add the unique solution to the result
        if (target < 0) {
            return;
        } else if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        // divide into subproblem, go to next level
        for (int i = pos; i < candidates.length; i++) {
            list.add(candidates[i]);
            helper(result, list, candidates, target - candidates[i], i); // since a number can be chosen infinitely, so next recursion still start with index i 

            // backtracking
            list.remove(list.size() - 1);
        }
    }
    
}