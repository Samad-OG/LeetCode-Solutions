import java.util.Arrays;

class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num + 1);
        }
        int[] dp = new int[maxVal + 1];
        int ans = 0;
        for (int x : nums) {
            dp[x + 1] = dp[x] + 1;
            dp[x] = dp[x - 1] + 1;
            ans = Math.max(ans, Math.max(dp[x], dp[x + 1]));
        }
        return ans;
    }
}
