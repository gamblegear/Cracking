/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
*/

/*
Great example to track Bottom-up. Also, take the advantage that the number of colums is the
same with the row index.
*/

public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int row = triangle.size()-1;
        int[] level = new int[triangle.size()];
        
        for(int i = 0; i < triangle.get(row).size(); i++)
            level[i] = triangle.get(row).get(i);
        
        for(int i = row-1; i >= 0; i--) {
            for(int j = 0; j < triangle.get(i).size(); j++) {
                level[j] = triangle.get(i).get(j) + Math.min(level[j], level[j+1]);
            }
        }
        
        return level[0];
    }
}