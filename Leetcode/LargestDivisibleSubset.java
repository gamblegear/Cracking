/*
This is my solution, which is recursion and not DP.
The tricky part is about the intermediate state, which can affect the later on result, so need to create tmp1 and tmp2 to eliminate this

Also, to keep track of the end result, declare result to be member of class
*/

public class Solution {
	private List<Integer> largest = new ArrayList<Integer>();
	
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0)
            return res;

        Arrays.sort(nums);
        //List<Integer> largest = new ArrayList<Integer>();
        List<Integer> tmp = new ArrayList<Integer>();

        buildSubset(nums, 0, tmp);
        return largest;
    }

    private void buildSubset(int[] nums, int index, List<Integer> tmp) {
        if(index == nums.length)
            return;

        List<Integer> tmp1 = new ArrayList<Integer>(tmp);
        List<Integer> tmp2 = new ArrayList<Integer>(tmp);
        
        buildSubset(nums, index+1, tmp1);
        if(largest.size() < tmp1.size())
        	largest = new ArrayList<Integer>(tmp1);
        
        if(isEligible(nums[index], tmp2)) {
        	tmp2.add(nums[index]);
        	
        	buildSubset(nums, index+1, tmp2);
        	if(largest.size() < tmp2.size())
        		largest = new ArrayList<Integer>(tmp2);
        }
        
        return;
    }

    private boolean isEligible(int toAdd, List<Integer> list) {
        for(Integer current: list) {
            if(toAdd % current != 0 && current % toAdd != 0)
                return false;
        }
        return true;
    }
}

// to add
// check eligible
// compare size
