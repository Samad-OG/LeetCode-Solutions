class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int zero = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zero = i;
                break;
            }
        }

        boolean isIncreasing = true;
        for (int i = 0; i < n; i++) {
            if (nums[(zero + i) % n] != i) {
                isIncreasing = false;
                break;
            }
        }

        boolean isDecreasing = true;
        for (int i = 0; i < n; i++) {
            if (nums[(zero - i + n) % n] != i) {
                isDecreasing = false;
                break;
            }
        }

        if (!isIncreasing && !isDecreasing) {
            return -1;
        }

        int minOps = Integer.MAX_VALUE;

        if (isIncreasing) {
            int optA = zero;
            int optB = 2 + ((n - zero) % n);
            minOps = Math.min(minOps, Math.min(optA, optB));
        }

        if (isDecreasing) {
            int optC = ((zero + 1) % n) + 1;
            int optD = n - zero;
            minOps = Math.min(minOps, Math.min(optC, optD));
        }

        return minOps;
    }
}
