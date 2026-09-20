import java.util.Arrays;

class Solution {
    public int findNonMinOrMax(int[] nums) {
        if (nums.length < 3) {
            return -1;
        }
        int[] sub = {nums[0], nums[1], nums[2]};
        Arrays.sort(sub);
        return sub[1];
    }
}
