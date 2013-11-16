// DP will cache the intermediate result

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
