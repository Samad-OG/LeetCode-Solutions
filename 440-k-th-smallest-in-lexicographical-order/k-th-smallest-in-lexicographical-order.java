class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;
        
        while (k > 0) {
            int steps = countSteps(n, curr, curr + 1);
            if (steps <= k) {
                curr += 1;
                k -= steps;
            } else {
                curr *= 10;
                k -= 1;
            }
        }
        
        return curr;
    }
    
    private int countSteps(int n, long n1, long n2) {
        int steps = 0;
        while (n1 <= n) {
            steps += Math.min(n + 1, n2) - n1;
            n1 *= 10;
            n2 *= 10;
        }
        return steps;
    }
}
