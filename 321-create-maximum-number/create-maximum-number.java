class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int[] maxResult = new int[k];
        
        int start = Math.max(0, k - n);
        int end = Math.min(k, m);
        
        for (int i = start; i <= end; i++) {
            int[] sub1 = maxArray(nums1, i);
            int[] sub2 = maxArray(nums2, k - i);
            int[] merged = merge(sub1, sub2, k);
            if (greater(merged, 0, maxResult, 0)) {
                maxResult = merged;
            }
        }
        
        return maxResult;
    }
    
    private int[] maxArray(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[k];
        int top = 0;
        
        for (int i = 0; i < n; i++) {
            while (top > 0 && result[top - 1] < nums[i] && (n - i) > (k - top)) {
                top--;
            }
            if (top < k) {
                result[top++] = nums[i];
            }
        }
        
        return result;
    }
    
    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] result = new int[k];
        int i = 0, j = 0;
        
        for (int r = 0; r < k; r++) {
            if (greater(nums1, i, nums2, j)) {
                result[r] = nums1[i++];
            } else {
                result[r] = nums2[j++];
            }
        }
        
        return result;
    }
    
    private boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                return true;
            }
            if (nums1[i] < nums2[j]) {
                return false;
            }
            i++;
            j++;
        }
        return i < nums1.length;
    }
}
