import java.util.*;

class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] result = new double[n - k + 1];
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Map<Integer, Integer> invalidCounts = new HashMap<>();
        
        int i = 0;
        while (i < k) {
            maxHeap.add(nums[i++]);
        }
        for (int j = 0; j < k / 2; j++) {
            minHeap.add(maxHeap.poll());
        }
        
        result[0] = getMedian(maxHeap, minHeap, k);
        
        for (int dest = 1; i < n; i++, dest++) {
            int prev = nums[i - k];
            int next = nums[i];
            
            invalidCounts.put(prev, invalidCounts.getOrDefault(prev, 0) + 1);
            
            int balance = 0;
            if (!maxHeap.isEmpty() && prev <= maxHeap.peek()) {
                balance--;
            } else {
                balance++;
            }
            
            if (!maxHeap.isEmpty() && next <= maxHeap.peek()) {
                maxHeap.add(next);
                balance++;
            } else {
                minHeap.add(next);
                balance--;
            }
            
            if (balance < 0) {
                maxHeap.add(minHeap.poll());
            } else if (balance > 0) {
                minHeap.add(maxHeap.poll());
            }
            
            prune(maxHeap, invalidCounts);
            prune(minHeap, invalidCounts);
            
            result[dest] = getMedian(maxHeap, minHeap, k);
        }
        
        return result;
    }
    
    private void prune(PriorityQueue<Integer> heap, Map<Integer, Integer> invalidCounts) {
        while (!heap.isEmpty() && invalidCounts.containsKey(heap.peek())) {
            int num = heap.peek();
            int count = invalidCounts.get(num);
            if (count == 1) {
                invalidCounts.remove(num);
            } else {
                invalidCounts.put(num, count - 1);
            }
            heap.poll();
        }
    }
    
    private double getMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap, int k) {
        if (k % 2 != 0) {
            return (double) maxHeap.peek();
        } else {
            return ((double) maxHeap.peek() + minHeap.peek()) * 0.5;
        }
    }
}
