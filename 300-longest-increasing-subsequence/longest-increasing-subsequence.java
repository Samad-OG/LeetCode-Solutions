import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        List<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > sub.get(sub.size() - 1)) {
                sub.add(num);
            } else {
                int idx = Collections.binarySearch(sub, num);
                if (idx < 0) {
                    idx = -(idx + 1);
                }
                sub.set(idx, num);
            }
        }
        
        return sub.size();
    }
}
