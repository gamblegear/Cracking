/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction
(ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
*/

// Need to figure out how the stock market works

public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int diff = 0;
        int low = Integer.MAX_VALUE;
        
        if(prices.length == 0 || prices.length == 1)
            return 0;
        
        for(int runner = 0; runner < prices.length; runner++) {
            if(prices[runner] < low)
                low = prices[runner];
            if(profit < (prices[runner] - low))
                profit = prices[runner] - low;
        }
        
        return profit;
    }
}