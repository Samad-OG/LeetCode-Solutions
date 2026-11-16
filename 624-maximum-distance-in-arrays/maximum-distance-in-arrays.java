class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int minVal = arrays.get(0).get(0);
        int maxVal = arrays.get(0).get(arrays.get(0).size() - 1);
        int maxDist = 0;

        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> current = arrays.get(i);
            int currMin = current.get(0);
            int currMax = current.get(current.size() - 1);

            maxDist = Math.max(maxDist, Math.max(Math.abs(currMax - minVal), Math.abs(maxVal - currMin)));

            minVal = Math.min(minVal, currMin);
            maxVal = Math.max(maxVal, currMax);
        }

        return maxDist;
    }
}
