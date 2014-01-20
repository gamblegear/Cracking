/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/

/*
This is to use the linear pattern to solve the 2D matrix problem.
Actually this is still a binary search.
*/

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        
        if(row == 1 && col == 1)
            return (matrix[0][0] == target? true: false);
        
        int i = 0;
        int p = row*col-1;
        
        while(p >= i) {
            int mid = (i+p)/2;
            int x = mid / col;
            int y = mid % col;
            
            if(matrix[x][y] == target)
                return true;
            else if(matrix[x][y] > target)
                p = mid - 1;
            else
                i = mid + 1;
        }
        
        return false;
    }
}