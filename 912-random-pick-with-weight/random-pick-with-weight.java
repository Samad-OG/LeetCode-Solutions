import java.util.Random;

class Solution {
    private int[] prefixSums;
    private int totalSum;
    private Random rand;

    public Solution(int[] w) {
        this.prefixSums = new int[w.length];
        int currentSum = 0;
        for (int i = 0; i < w.length; i++) {
            currentSum += w[i];
            this.prefixSums[i] = currentSum;
        }
        this.totalSum = currentSum;
        this.rand = new Random();
    }
    
    public int pickIndex() {
        int target = rand.nextInt(totalSum) + 1;
        int low = 0, high = prefixSums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (prefixSums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
