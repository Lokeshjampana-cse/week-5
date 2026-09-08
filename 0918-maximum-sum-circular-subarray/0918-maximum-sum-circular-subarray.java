class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;

        int currentMax = 0;
        int maxSum = Integer.MIN_VALUE;

        int currentMin = 0;
        int minSum = Integer.MAX_VALUE;

        for (int num : nums) {

            // Maximum subarray sum (Kadane's algorithm)
            currentMax = Math.max(num, currentMax + num);
            maxSum = Math.max(maxSum, currentMax); // FIX

            // Minimum subarray sum
            currentMin = Math.min(num, currentMin + num);
            minSum = Math.min(minSum, currentMin);

            total += num;
        }

        // If all elements are negative
        if (maxSum < 0) {
            return maxSum;
        }

        // Non-circular maximum vs circular maximum
        return Math.max(maxSum, total - minSum);
    }
}
