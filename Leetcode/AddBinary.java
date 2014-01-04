/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/

/*
Ways to deal with String, Char and Integer:
1. toArray();
2. charAt();
3. Integer.toString(num);
4. String = "";
*/

public class Solution {
    public String addBinary(String a, String b) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        int ap = a.length()-1;
        int bp = b.length()-1;
        String sum = "";
        int temp = 0;
        int carry = 0;
        
        while(ap >= 0 || bp >= 0) {
            if(ap >= 0 && bp >=0)
                temp = (a.charAt(ap) - '0') + (b.charAt(bp) - '0') + carry;
            else if(ap >= 0)
                temp = (a.charAt(ap) - '0') + carry;
            else
                temp = (b.charAt(bp) - '0') + carry;
            
            if(temp >= 2) {
                temp = temp - 2;
                carry = 1;
            } else
                carry = 0;
            
            sum = Integer.toString(temp) + sum;
            
            ap--;
            bp--;
        }
        
        if(carry == 1)
            sum = "1" + sum;
        
        return sum;
    }
}