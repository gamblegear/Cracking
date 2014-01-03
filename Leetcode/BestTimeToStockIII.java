// This is the best time to buy and sell III

/*
This is the DP solution.
Of course we can use the embeded for solution which takes O(N^2), not good

Since we are allowed to do at most 2 transactions, we can divide the array into 2 parts
and caculate the left and right respectively.
- why we need to calculate the left and right respectively? Because the right value should
not rely on the left "buy" value. They are independent.

The idea of DP is to "store" the intermediate values and heavily rely on the previous value,
say value[i] relies on value[i-1].
*/

public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len == 0 || len == 1)
            return 0;
            
        int[] left = new int[len];
        int[] right = new int[len];

        int min = prices[0];
        for(int i = 1; i < len; i++) {
            left[i] = left[i-1] > (prices[i] - min)? left[i-1]: (prices[i] - min);
            min = min < prices[i]? min: prices[i];
        }
        
        int max = prices[len-1];
        for(int i = len-2; i >= 0; i--) {
            right[i] = right[i+1] > (max - prices[i])? right[i+1]: (max - prices[i]);
            max = max > prices[i]? max: prices[i];
        }
        
        int profit = 0;
        for(int i = 0; i < len; i++)
            profit = profit > (left[i] + right[i])? profit: (left[i] + right[i]);
        
        return profit;
    }
}