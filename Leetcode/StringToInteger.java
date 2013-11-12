// need to consider the order of conditions in "if"

public class Solution {
    public int atoi(String str) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if(str.equals(""))
            return 0;
        
        int pos = 0;
        long res = 0;
        int temp = 0;
        char flag = '+';
        
        str = str.trim();
        
        
        if(str.charAt(0) == '+' || str.charAt(0) == '-') {
            flag = str.charAt(0);
            pos++;
        }
        
        while(true) {
	    // order matters
            if(pos < str.length() && str.charAt(pos) >= '0' && str.charAt(pos) <= '9') {
                temp = (int) str.charAt(pos) - '0';
                res = res * 10 + (long) temp;
                pos++;
            } else
                break;
        }
        
        if(flag == '-')
            res = -res;
            
        if(res > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        
        if(res < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        
        return (int) res;
    }
}
