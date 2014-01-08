/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
*/

/*
The idea is to use recursive ways.
1. Like climing stairs. Also here we keep the previous result in HashMap (DP concepts)
2. Need to consider one typical situation: when the code <= 26 and the remaining length of str is 2.
*/

public class Solution {
    public int numDecodings(String s) {
        HashMap map = new HashMap<String ,Integer>();
        return decoding(s, map);
    }
    
    public int decoding(String str, HashMap<String, Integer> map) {
        int len = str.length();
        if(len == 0) return 0;
        if(str.charAt(0) == '0') return 0;
        if(len == 1) return 1;
        
        if(map.containsKey(str))
            return map.get(str);
        
        int code = Integer.parseInt(str.substring(0,2));
        int ways = 0;
        
        if(code > 26)
            ways = decoding(str.substring(1), map);
        else if (len == 2)
            ways = 1 + decoding(str.substring(1), map);
        else
            ways = (decoding(str.substring(1), map) + decoding(str.substring(2), map));
        
        map.put(str, ways);
        return ways;
    }
}