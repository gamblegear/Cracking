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


/*
also we can use boolean matrix instead of hashMap. But should be careful about how to initialize the matrix
*/

public class Solution {
    List<List<String>> ret;
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        for (int i = 0; i < n; i++)
            isPalindrome[i][i] = true;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 2 || isPalindrome[i + 1][j - 1])
                        isPalindrome[i][j] = true;
                }
            }
        }
        ret = new LinkedList<>();
        List<String> list = new LinkedList<>();
        partition(s, 0, isPalindrome, list);
        return ret;
    }
    
    private void partition(String s, int start, boolean[][] isPalindrome, List<String> list) {
        if (start == s.length()) {
            List<String> newList = new LinkedList<>();
            newList.addAll(list);
            ret.add(newList);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome[start][i]) {
                list.add(s.substring(start, i + 1));
                partition(s, i + 1, isPalindrome, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
