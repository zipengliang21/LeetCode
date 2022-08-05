class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 4) {
            return result;
        }

        // Sorting
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 3; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            for(int j = i + 1; j < nums.length - 2; j++) {
                if(j > i + 1 && nums[j] == nums[j-1]) {
                    continue;
                }
                int start = j + 1;
                int end = nums.length - 1;

                while(start < end) {
                    long sum = (long) nums[i] + (long) nums[j] + (long) nums[start] + (long) nums[end];

                    if(sum == target) {
                        // [n1, n2, n3, n4]
                        List<Integer> fourElementList= new ArrayList<>();
                        fourElementList.add(nums[i]);
                        fourElementList.add(nums[j]);
                        fourElementList.add(nums[start]);
                        fourElementList.add(nums[end]);
                        result.add(fourElementList);
                    
                        // Remove duplicated - start: left -> right  start + 1 <= length - 1
                        while(start < end && nums[start] == nums[start + 1]) {
                            start++;
                        }
                        start++;

                        // end: right -> left   end >= 0
                        while(start < end && nums[end] == nums[end - 1]) {
                            end--;
                        }
                        end--;
                    }
                    else if(sum < target) {
                        start++;
                    } else {
                        // sum > target
                        end--;
                    }
                }
            } 
        }

        return result;
    }
}