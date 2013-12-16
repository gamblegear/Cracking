/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*/


// This is not the DP method. This is only iterative way
// Refer to Fibonacci to check DP.
// If in DP, there should be a seperate array to keep track of intermediate values

public class Solution {
    public int climbStairs(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        
        int[] cache = new int[n+1];
        
        cache[0] = 0;
        cache[1] = 1;
        cache[2] = 2;
       
        for(int i = 3; i <= n; i++)
            cache[i] = cache[i-1] + cache[i-2];
        
        return cache[n];
    }
}
