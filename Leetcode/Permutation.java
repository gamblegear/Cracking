/*
Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/

// The tricky part is that each time in the loop, we need to 

public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        boolean[] used = new boolean[num.length];
        for(int i = 0; i < num.length; i++)
            used[i] = false;
            
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> per = new ArrayList<Integer>();
        generate(num, used, per, res);
        
        return res;
    }
    
    public void generate(int[] num, boolean[] used, ArrayList per, ArrayList res) {
        if(per.size() == num.length) {
            res.add(per);
            return;
        }
        
        for(int i = 0; i < num.length; i++) {
            if(used[i] == false) {
                ArrayList<Integer> perArr = new ArrayList<Integer>(per);
                perArr.add(num[i]);
                used[i] = true;
                generate(num, used, perArr, res);
                used[i] = false;
            } else {
                continue;
            }
        }
    }
}