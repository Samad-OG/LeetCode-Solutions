import java.util.*;

class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> Integer.compare(a[1], b[1]));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int totalTime = 0;

        for (int[] course : courses) {
            totalTime += course[0];
            maxHeap.offer(course[0]);
            if (totalTime > course[1]) {
                totalTime -= maxHeap.poll();
            }
        }

        return maxHeap.size();
    }
}
