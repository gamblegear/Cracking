/*
Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.
*/

public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        HashMap<String, Integer> FreqMap = new HashMap<String, Integer>();
        ArrayList<String> resList = new ArrayList<String>();

        for(String str: strs) {
        	char[] strArr = str.toCharArray();
        	Arrays.sort(strArr);
        	String ss = new String(strArr);

        	if(FreqMap.containsKey(ss)) {
        		FreqMap.put(ss, (FreqMap.get(ss) + 1));
        	} else {
        		FreqMap.put(ss, 1);
        	}
        }

        for(String str: strs) {
        	char[] strArr = str.toCharArray();
        	Arrays.sort(strArr);
        	String ss = new String(strArr);

        	if(FreqMap.containsKey(ss) && FreqMap.get(ss) > 1) {
        		resList.add(str);
        	}
        }

        return resList;
    }
}