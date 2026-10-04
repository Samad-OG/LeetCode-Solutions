class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        
        int sold = 0;
        int held = -prices[0];
        int reset = 0;
        
        for (int i = 1; i < prices.length; i++) {
            int prevSold = sold;
            sold = held + prices[i];
            held = Math.max(held, reset - prices[i]);
            reset = Math.max(reset, prevSold);
        }
        
        return Math.max(sold, reset);
    }
}
