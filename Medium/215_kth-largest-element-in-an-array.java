// With heap sort 
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int heapSize = nums.length;

        // build max heap
        buildMaxHeap(nums);

        // sort the k - 1 largest elements
        for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {
            swap(nums, 0, i);
            heapSize--;
            maxHeapify(nums, 0 , heapSize);
        }
        
        return nums[0];
    }

    private void buildMaxHeap(int[] nums) {
        for (int i = nums.length / 2; i >= 0; i--) {
            maxHeapify(nums, i, nums.length);
        }
    }

    private void maxHeapify(int[] nums, int i, int heapSize) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int largest = i;
        if (l < heapSize && nums[l] > nums[largest]) {
            largest = l;
        } else {
            largest = i;
        }

        if (r < heapSize && nums[r] > nums[largest]) {
            largest = r;
        }

        if (largest != i) {
            swap(nums, i , largest);
            maxHeapify(nums, largest, heapSize);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// With heap java api approach
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        // max heap
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);

        for (int num : nums) {
            heap.offer(num);
        }

        // delete the peak elements k - 1 times
        for (int i = 0; i < k - 1; i++) {
            heap.poll();
        }

        // obtain the kth largest element
        return heap.peek();
    }
}


class Solution {
    public int findKthLargest(int[] nums, int k) {
        int pivot = nums.length - k + 1;
        return quickSelect(0, nums.length - 1, pivot, nums);
    }

    private int quickSelect(int start, int end, int k, int[] nums) {
        // base case
        if (start == end) {
            return nums[start];
        }
        int index = partition(nums, start, end);

        // including nums[index]
        int num = index - start + 1;
        if (k == num) {
            return nums[index];
        } else if (k < num) {
            return quickSelect(start, index - 1, k, nums);
        } else {
            return quickSelect(index + 1, end, k - num, nums);
        }
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = start; // pivot = end;
        int value = nums[pivot];

        while (start < end) {
            while (start < end && nums[end] >= value) {
                end--;
            }

            // Find the element that smaller than value;
            // nums[start] = nums[end];
            swap(nums, start, end);

            while (start < end && nums[start] <= value) {
                start++;
            }

            // Find the element that smaller than value;
            // nums[end] = nums[start];
            swap(nums, end, start);
        }
        // nums[start] = value;
        return start;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}