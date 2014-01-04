/*
Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S) {
       HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
       ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
       Arrays.sort(S);
       
       for(int i = 0; i <= S.length; i++) {
           ArrayList<Integer> tmp = new ArrayList<Integer>();
           getSubsets(S , set, tmp, i, 0);
       }
       
       for(ArrayList<Integer> list: set) {
           res.add(list);
       }
       
       return res;
    }
    
    public void getSubsets(int[] S, HashSet<ArrayList<Integer>> set, ArrayList<Integer> tmp, int len, int index) {
        if(tmp.size() == len) {
            ArrayList<Integer> list = new ArrayList<Integer>(tmp);
            set.add(list);
            return;
        }
        
        for(int i = index; i < S.length; i++) {
            tmp.add(S[i]);
            getSubsets(S, set, tmp, len, i+1);
            tmp.remove(tmp.size()-1);
        }
    }
}