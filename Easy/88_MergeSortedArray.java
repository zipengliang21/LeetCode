class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];
        int index1 = 0;
        int index2 = 0;
        int index = 0;

        while(index1 < m && index2 < n) {
            if(nums1[index1] <= nums2[index2]) {
                result[index++] = nums1[index1++];
            } else {
                result[index++] = nums2[index2++];
            }
        }

        // check whether nums1 is empty or not
        while(index1 < m) {
            result[index++] = nums1[index1++];
        }

        // check whether nums2 is empty or not
        while(index2 < n) {
            result[index++] = nums2[index2++];
        }

        for(int i = 0; i< m + n; i++) {
            nums1[i] = result[i];
        }
    }




/**
    public int[] merge(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        int index1 = 0;
        int index2 = 0;
        int index = 0;

        while(index1 < nums1.length && index2 < nums2.length) {
            if(nums1[index1] <= nums[index2]) {
                result[index++] = nums1[index1++];
            } else {
                result[index++] = nums1[index2++];
            }
        }

        // check whether nums1 is empty or not
        while(index1 < nums1.length) {
            result[index++] = nums1[index1++];
        }

        // check whether nums2 is empty or not
        while(index2 < nums2.length) {
            result[index++] = nums2[index2++];
        }

        return result;
    }

 */
}