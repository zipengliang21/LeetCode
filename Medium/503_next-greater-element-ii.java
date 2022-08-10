package Medium;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < 2 * nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % nums.length]) {
                int index = stack.pop();
                result[index] = nums[i % nums.length];
            }
            stack.push(i % nums.length);
        }

        return result;
    }
}
