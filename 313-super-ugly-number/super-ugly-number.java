class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        long[] ugly = new long[n];
        ugly[0] = 1;
        
        int k = primes.length;
        int[] indices = new int[k];
        
        for (int i = 1; i < n; i++) {
            long minNext = Long.MAX_VALUE;
            
            for (int j = 0; j < k; j++) {
                long next = ugly[indices[j]] * primes[j];
                if (next < minNext) {
                    minNext = next;
                }
            }
            
            ugly[i] = minNext;
            
            for (int j = 0; j < k; j++) {
                if (ugly[indices[j]] * primes[j] == minNext) {
                    indices[j]++;
                }
            }
        }
        
        return (int) ugly[n - 1];
    }
}
