package BuyAndSellCrypto;

//https://neetcode.io/problems/buy-and-sell-crypto

public class Solution {
    public int maxProfit(int[] prices)
    {
        int maxProfit = 0, minLeftValue = prices[0];
        for(int sellDay = 1; sellDay < prices.length; sellDay++){
            maxProfit = Math.max(maxProfit, prices[sellDay] - minLeftValue);

            minLeftValue = Math.min(minLeftValue, prices[sellDay]);
        }
        return maxProfit;
    }
}
