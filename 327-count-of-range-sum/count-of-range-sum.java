class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sums = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        return countWhileMergeSort(sums, 0, n + 1, lower, upper);
    }

    private int countWhileMergeSort(long[] sums, int start, int end, int lower, int upper) {
        if (end - start <= 1) {
            return 0;
        }
        
        int mid = (start + end) / 2;
        int count = countWhileMergeSort(sums, start, mid, lower, upper) 
                  + countWhileMergeSort(sums, mid, end, lower, upper);
        
        int j = mid;
        int k = mid;
        for (int i = start; i < mid; i++) {
            while (k < end && sums[k] - sums[i] < lower) {
                k++;
            }
            while (j < end && sums[j] - sums[i] <= upper) {
                j++;
            }
            count += j - k;
        }
        
        long[] cache = new long[end - start];
        int r = 0;
        int idx1 = start;
        int idx2 = mid;
        
        while (idx1 < mid && idx2 < end) {
            if (sums[idx1] < sums[idx2]) {
                cache[r++] = sums[idx1++];
            } else {
                cache[r++] = sums[idx2++];
            }
        }
        
        while (idx1 < mid) {
            cache[r++] = sums[idx1++];
        }
        while (idx2 < end) {
            cache[r++] = sums[idx2++];
        }
        
        System.arraycopy(cache, 0, sums, start, end - start);
        return count;
    }
}
