// Small modification on Permutation
// Simply use the uniqueness of a HashSet

public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        boolean[] used = new boolean[num.length];
        for(int i = 0; i < num.length; i++)
            used[i] = false;
            
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        ArrayList<Integer> per = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        generate(num, used, per, set);
        
        for(ArrayList list: set) {
            res.add(list);
        }
        
        return res;
    }
    
    public void generate(int[] num, boolean[] used, ArrayList per, HashSet set) {
        if(per.size() == num.length) {
            set.add(per);
            return;
        }
        
        for(int i = 0; i < num.length; i++) {
            if(used[i] == false) {
                ArrayList<Integer> perArr = new ArrayList<Integer>(per);
                perArr.add(num[i]);
                used[i] = true;
                generate(num, used, perArr, set);
                used[i] = false;
            } else {
                continue;
            }
        }
    }
}