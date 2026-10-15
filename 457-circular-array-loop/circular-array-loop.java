class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                continue;
            }
            
            int slow = i;
            int fast = i;
            boolean isForward = nums[i] > 0;
            
            while (true) {
                slow = getNextIndex(nums, slow, isForward);
                if (slow == -1) break;
                
                fast = getNextIndex(nums, fast, isForward);
                if (fast == -1) break;
                
                fast = getNextIndex(nums, fast, isForward);
                if (fast == -1) break;
                
                if (slow == fast) {
                    return true;
                }
            }
            
            int curr = i;
            while (getNextIndex(nums, curr, isForward) != -1) {
                int next = getNextIndex(nums, curr, isForward);
                nums[curr] = 0;
                curr = next;
            }
        }
        
        return false;
    }
    
    private int getNextIndex(int[] nums, int index, boolean isForward) {
        boolean currentDirection = nums[index] > 0;
        if (currentDirection != isForward || nums[index] == 0) {
            return -1;
        }
        
        int n = nums.length;
        int nextIndex = (index + nums[index]) % n;
        if (nextIndex < 0) {
            nextIndex += n;
        }
        
        if (nextIndex == index) {
            return -1;
        }
        
        return nextIndex;
    }
}
