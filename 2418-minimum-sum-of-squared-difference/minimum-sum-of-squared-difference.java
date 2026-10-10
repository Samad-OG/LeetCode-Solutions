class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int maxDiff = 0;
        int[] diff = new int[n];
        
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            if (diff[i] > maxDiff) {
                maxDiff = diff[i];
            }
        }
        
        int[] freq = new int[maxDiff + 1];
        long totalDiffSum = 0;
        for (int d : diff) {
            freq[d]++;
            totalDiffSum += d;
        }
        
        long k = (long) k1 + k2;
        if (totalDiffSum <= k) {
            return 0;
        }
        
        for (int d = maxDiff; d > 0; d--) {
            if (freq[d] > 0) {
                if (k >= freq[d]) {
                    k -= freq[d];
                    freq[d - 1] += freq[d];
                    freq[d] = 0;
                } else {
                    freq[d - 1] += k;
                    freq[d] -= (int) k;
                    k = 0;
                    break;
                }
            }
        }
        
        long ans = 0;
        for (int d = 1; d <= maxDiff; d++) {
            if (freq[d] > 0) {
                ans += (long) freq[d] * d * d;
            }
        }
        
        return ans;
    }
}
