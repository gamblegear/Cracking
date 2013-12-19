/*
If this is in Integer, then need to think about the step length of 1.
Each step is 1 length long.
*/

public class Solution {
    public int sqrt(int x) {
        if (x <= 0) {
            return 0;
        }
    
        long low = 1;
        long high = x;
        while (low < high) {
            long mid = (low + high) / 2;
            if (mid * mid > (long)x) {
                if ((mid - 1) * (mid - 1) < (long)x) {
                    return (int)mid - 1;
                }
                high = mid - 1;
            }
            else {
                if ((mid + 1) * (mid + 1) > (long)x) {
                    return (int)mid;
                }
                low = mid + 1;
            }
        }
        return (int)low;
    }
}