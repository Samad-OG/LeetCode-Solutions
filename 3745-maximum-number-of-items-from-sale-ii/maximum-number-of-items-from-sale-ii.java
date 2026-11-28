class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] freq = new int[n + 1];
        int minPrice = Integer.MAX_VALUE;
        for (int[] item : items) {
            freq[item[0]]++;
            minPrice = Math.min(minPrice, item[1]);
        }

        int[] multiples = new int[n + 1];
        Map<Integer, Long> availablePairs = new TreeMap<>();
        for (int[] item : items) {
            int factor = item[0];
            int price = item[1];
            if ((long) price >= (long) minPrice * 2) {
                continue;
            }
            if (multiples[factor] == 0) {
                for (int j = factor; j <= n; j += factor) {
                    multiples[factor] += freq[j];
                }
            }
            long freeCopies = multiples[factor] - 1;
            if (freeCopies > 0) {
                availablePairs.merge(price, freeCopies, Long::sum);
            }
        }

        int totalItems = 0;
        for (Map.Entry<Integer, Long> entry : availablePairs.entrySet()) {
            int price = entry.getKey();
            if (budget < price) {
                break;
            }
            int count = (int) Math.min(entry.getValue(), (long) (budget / price));
            budget -= price * count;
            totalItems += count * 2;
        }

        return totalItems + budget / minPrice;
    }
}

