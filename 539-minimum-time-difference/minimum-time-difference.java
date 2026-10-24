import java.util.List;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] minutes = new boolean[1440];
        
        for (String time : timePoints) {
            int h = Integer.parseInt(time.substring(0, 2));
            int m = Integer.parseInt(time.substring(3, 5));
            int totalMinutes = h * 60 + m;
            
            if (minutes[totalMinutes]) {
                return 0;
            }
            minutes[totalMinutes] = true;
        }
        
        int minDiff = Integer.MAX_VALUE;
        int firstTime = -1;
        int prevTime = -1;
        
        for (int i = 0; i < 1440; i++) {
            if (minutes[i]) {
                if (firstTime == -1) {
                    firstTime = i;
                } else {
                    minDiff = Math.min(minDiff, i - prevTime);
                }
                prevTime = i;
            }
        }
        
        minDiff = Math.min(minDiff, (1440 - prevTime) + firstTime);
        
        return minDiff;
    }
}
