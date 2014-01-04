/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like
(ie, buy one and sell one share of the stock multiple times).However, you may not engage in multiple
transactions at the same time (ie, you must sell the stock before you buy again).
*/

// The idea is to find the increasing part of the array

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0 || prices.length == 1)
            return 0;
        
        int current = 0;
        int profit = 0;
        int diff = 0;
        
        for(int i = 0; i < prices.length; i++) {
            diff = prices[i] - prices[current];
            if(diff > 0)
                profit += diff;
            current = i;
        }
        
        return profit;
    }
}
