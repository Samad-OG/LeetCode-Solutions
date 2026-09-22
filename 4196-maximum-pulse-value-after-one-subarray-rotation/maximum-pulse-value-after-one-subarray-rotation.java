class Solution {
    public long maxValue(int[] nums) {
        int n = nums.length;
        long originalPulse = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                originalPulse += nums[i];
            } else {
                originalPulse -= nums[i];
            }
        }

        long maxEven = Long.MIN_VALUE / 2;
        long maxOdd = Long.MIN_VALUE / 2;
        long maxEvenSum = 0;

        for (int i = 0; i < n; i++) {
            long b = (i % 2 == 0) ? -nums[i] : nums[i];
            
            long nextMaxOdd = Math.max(b, maxEven + b);
            long nextMaxEven = maxOdd + b;

            maxOdd = nextMaxOdd;
            maxEven = nextMaxEven;

            maxEvenSum = Math.max(maxEvenSum, maxEven);
        }

        return originalPulse + 2 * maxEvenSum;
    }
}
