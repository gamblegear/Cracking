/*
If this is in Integer, then need to think about the step length of 1.
Each step is 1 length long.
*/

public class Solution {
    public int sqrt(int x) {
        long i = 0;
        long j = x/2+1;
        
        while(i <= j) {
            long mid = (i + j)/2;
            if(mid * mid == x)
                return (int)mid;
            else if(mid * mid < x)
                i = mid + 1;
            else
                j = mid - 1;
        }
        
        return (int)j;
    }
}
