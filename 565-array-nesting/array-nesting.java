class Solution {
    public int arrayNesting(int[] nums) {
        int maxLen = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -1) {
                int start = nums[i];
                int count = 0;
                
                while (nums[start] != -1) {
                    int temp = start;
                    start = nums[start];
                    nums[temp] = -1;
                    count++;
                }
                
                maxLen = Math.max(maxLen, count);
            }
        }
        
        return maxLen;
    }
}
