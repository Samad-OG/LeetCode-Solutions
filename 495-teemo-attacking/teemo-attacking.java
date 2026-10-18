class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) {
            return 0;
        }
        
        int totalDuration = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            totalDuration += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
        }
        
        return totalDuration + duration;
    }
}
