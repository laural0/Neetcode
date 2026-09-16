package BestTimeToBuyAndSellStock2;

public class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if (prices.length <= 1) return maxProfit;

        int a = 0, b = 1;
        while (b < prices.length) {
            if(prices[b] - prices[a] > 0) maxProfit += prices[b] - prices[a];
            a++;
            b++;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
