import java.util.Stack;

class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        
        int n = nums.length;
        int numK = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < numK) {
                return true;
            }
            
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                numK = stack.pop();
            }
            
            stack.push(nums[i]);
        }
        
        return false;
    }
}
