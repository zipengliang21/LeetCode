package Easy;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // key: element itself; value: the first larger element in the right
        Map<Integer, Integer> map = new HashMap<>();

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                int index = stack.pop();
                map.put(nums2[index], nums2[i]);
            }

            stack.push(i);
        }

        // find the corresponding values for nums1[i] in map
        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);
        for (int i = 0; i < nums1.length; i++) {
            int key = nums1[i];
            if (map.containsKey(key)) {
                result[i] = map.get(key);
            }
        }

        return result;
    }
}
