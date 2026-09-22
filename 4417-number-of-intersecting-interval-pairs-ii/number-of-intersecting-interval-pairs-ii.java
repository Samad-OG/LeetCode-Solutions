import java.util.Arrays;

class Solution {
    public long countIntersectingIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        long count = 0;
        
        for (int i = 0; i < n; i++) {
            int end = intervals[i][1];
            int low = i + 1;
            int high = n - 1;
            int validIndex = i;
            
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (intervals[mid][0] <= end) {
                    validIndex = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            
            count += (validIndex - i);
        }
        
        return count;
    }
}
