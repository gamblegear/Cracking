/*
Given a set of distinct integers, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

/*
Cannot follow the neat recursive methods used in Combinations. Because each time a subset is included,
next time, it will be extended one elements and may be a duplicate to before.
eg. [1], [1,2] -> [1,2], [1,2,3]
*/

/*
Think about how you would solve this problem in real world.
I will find the subsets size of 0, 1, 2... until the size of original set.
Among those subsets whose sizes are the same, I will iterate to find all the qualified subsets.
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
       ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
       Arrays.sort(S);
       
       for(int i = 0; i <= S.length; i++) {
           ArrayList<Integer> tmp = new ArrayList<Integer>();
           getSubsets(S ,res, tmp, i, 0);
       }
       
       return res;
    }
    
    public void getSubsets(int[] S, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tmp, int len, int index) {
        if(tmp.size() == len) {
            ArrayList<Integer> list = new ArrayList<Integer>(tmp);
            res.add(list);
            return;
        }
        
        for(int i = index; i < S.length; i++) {
            tmp.add(S[i]);
            getSubsets(S, res, tmp, len, i+1);
            tmp.remove(tmp.size()-1);
        }
    }
}