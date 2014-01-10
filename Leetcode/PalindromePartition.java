/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
*/

/*
DFS:
1. every time a new state is passed to the next iteration, we need to remove the action we took
before this step, so that the action will not affect others;
*/

public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        ArrayList<String> list = new ArrayList<String>();
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
        part_dfs(s, res, list, map, 0);
        return res;
    }
    
    public void part_dfs(String str, ArrayList<ArrayList<String>> res, ArrayList<String> list, HashMap<String, Boolean> map, int start) {
        if(start == str.length()) {
            res.add(new ArrayList<String>(list));
            return;
        }
        
        for(int i = start; i < str.length(); i++) {
            boolean isPalindrome = false;
            String sub = str.substring(start, i+1);
            if(map.get(sub) != null) {
                isPalindrome = map.get(sub);
            } else {
                isPalindrome = checkPalindrome(sub);
                map.put(sub, isPalindrome);
            }
            if(isPalindrome) {
                list.add(sub);
                part_dfs(str, res, list, map, i+1);
                list.remove(list.size()-1);
            }
        }
    }
    
    public boolean checkPalindrome(String s) {
        if(s.length() == 0)
            return true;
        
        for(int i = 0; i <= s.length()/2; i++) {
            if(s.charAt(i) != s.charAt(s.length()-1-i))
                return false;
        }
        return true;
    }
}