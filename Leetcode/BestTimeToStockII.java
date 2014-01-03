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


// This is the best time to buy and sell III

public int maxProfit(int[] prices) {  
     if(prices.length <= 1){  
       return 0;  
     }  
     //if sell at this day or before this day, the max profit  
     int[] store = new int[prices.length];  
     int start = 0 ;  
     //go from start  
     for (int i = 1 ; i < prices.length;i++){  
       // if larger than start, calculate the profit and compare with former one  
       // always store the largest profit into store[]  
       if(prices[i] > prices[start]){  
         store[i] = Math.max(prices[i] - prices[start], store[i-1]);  
       }  
       // if smaller than start, update start index, this is the new start index,  
       // just copy the former store value  
       else {  
         store[i] = store[i-1];  
         start = i;  
       }  
     }  
     // set the last value as result  
     int result = store[prices.length - 1];  
     // go from last element  
     start = prices.length - 1;  
     for (int i = prices.length - 2;i >= 0 ;i--) {  
       // if smaller than start, calculate the profit,   
       //then plus the store[i](if sell at this day or before this day, the max profit)  
       // compare with result  
       if(prices[i] < prices[start]){  
         result = Math.max(result, prices[start] - prices[i] + store[i]);  
       } else {  
         start = i;  
       }  
     }  
     return result;  
   }  