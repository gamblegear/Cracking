/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

*/

/*
K-level problems, in which K is not a constant, should think of recursion.

Recall the typical steps of recursion.
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        if(k == 1) {
            for(int i = 1; i <= n; i++) {
                ArrayList<Integer> comb = new ArrayList<Integer>();
                comb.add(i);
                res.add(comb);
            }
            return res;
        }
        
        ArrayList<ArrayList<Integer>> pre = combine(n, k-1);
        for(ArrayList<Integer> c: pre) {
            int last = c.get(c.size()-1);
            for(int i = last+1; i <= n; i++) {
                ArrayList<Integer> temp = new ArrayList<Integer>(c);
                temp.add(i);
                res.add(temp);
            }
        }
        return res;
    }
}