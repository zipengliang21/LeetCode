class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();

        // unique solution
        StringBuffer sb = new StringBuffer();

        helper(result, sb, n, new int[] { 0, 1 });

        return result;
    }

    private void helper(List<Integer> result, StringBuffer sb, int n, int[] nums) {
        // when should we terminate the recursion
        // && when should we add the unique solution to result
        if (sb.length() == n) {
            // convert from binary to decimal
            Integer value = Integer.valueOf(sb.toString(), 2);
            result.add(value);
            return;
        }

        // next level recursion, how to distinguish 0 or 1
        sb.append(nums[0]);
        helper(result, sb, n, new int[] { 0, 1 });
        // backtracking
        sb.deleteCharAt(sb.length() - 1);

        sb.append(nums[1]);
        helper(result, sb, n, new int[] { 1, 0 });
        // backtracking
        sb.deleteCharAt(sb.length() - 1);
    }
}