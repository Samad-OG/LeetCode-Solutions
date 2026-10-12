import java.util.List;

class Solution {
    public int maxSum(List<Integer> nums, int k) {
        long mod = 1_000_000_007L;
        int[] bitCount = new int[31];
        
        for (int num : nums) {
            for (int bit = 0; bit < 31; bit++) {
                if (((num >> bit) & 1) == 1) {
                    bitCount[bit]++;
                }
            }
        }
        
        long answer = 0;
        
        for (int i = 0; i < k; i++) {
            long current = 0;
            for (int bit = 0; bit < 31; bit++) {
                if (bitCount[bit] > 0) {
                    current |= (1L << bit);
                    bitCount[bit]--;
                }
            }
            answer = (answer + current * current) % mod;
        }
        
        return (int) answer;
    }
}
