class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        // greedy approach
        for (int price : prices) {
            minPrice = price < minPrice ? price : minPrice;
            maxProfit = (price - minPrice) > maxProfit ? (price - minPrice) : maxProfit;
        }
        return maxProfit;
    }
}