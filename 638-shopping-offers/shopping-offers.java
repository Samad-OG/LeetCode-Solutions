class Solution {
    private Map<List<Integer>, Integer> memo = new HashMap<>();

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if (memo.containsKey(needs)) {
            return memo.get(needs);
        }

        int minCost = directPurchase(price, needs);
        int n = price.size();

        for (List<Integer> offer : special) {
            List<Integer> nextNeeds = new ArrayList<>();
            boolean valid = true;

            for (int i = 0; i < n; i++) {
                if (needs.get(i) < offer.get(i)) {
                    valid = false;
                    break;
                }
                nextNeeds.add(needs.get(i) - offer.get(i));
            }

            if (valid) {
                minCost = Math.min(minCost, offer.get(n) + shoppingOffers(price, special, nextNeeds));
            }
        }

        memo.put(needs, minCost);
        return minCost;
    }

    private int directPurchase(List<Integer> price, List<Integer> needs) {
        int total = 0;
        for (int i = 0; i < price.size(); i++) {
            total += price.get(i) * needs.get(i);
        }
        return total;
    }
}
