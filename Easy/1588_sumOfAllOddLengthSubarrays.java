class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int result = 0;
        int[] prefixSum = new int[arr.length + 1];

        // O(n)
        for (int i = 0; i < arr.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }

        // O (n ^ 2)
        for (int i = 0; i < arr.length; i++) {
            for (int len = 1; i + len <= arr.length; len += 2) {
                result += prefixSum[i + len] - prefixSum[i];
            }
        }

        return result;
    }
}

/**
 * //BF
 * public int sumOddLengthSubarrays(int[] arr) {
 * if(arr == null || arr.length == 0) {
 * return 0;
 * }
 * 
 * int result = 0;
 * 
 * for(int i = 0; i < arr.length; i++) {
 * for(int len = 1; i + len <= arr.length; len += 2) {
 * for(int j = i; j < i + len; j++) {
 * result += arr[j];
 * }
 * }
 * }
 * 
 * return result;
 * }
 */