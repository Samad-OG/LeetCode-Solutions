import java.util.TreeSet;

class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxSum = Integer.MIN_VALUE;

        for (int left = 0; left < cols; left++) {
            int[] rowSums = new int[rows];
            for (int right = left; right < cols; right++) {
                for (int r = 0; r < rows; r++) {
                    rowSums[r] += matrix[r][right];
                }

                TreeSet<Integer> prefixSums = new TreeSet<>();
                prefixSums.add(0);
                int currentSum = 0;

                for (int sum : rowSums) {
                    currentSum += sum;
                    Integer target = prefixSums.ceiling(currentSum - k);
                    if (target != null) {
                        maxSum = Math.max(maxSum, currentSum - target);
                    }
                    prefixSums.add(currentSum);
                }
            }
        }

        return maxSum;
    }
}
