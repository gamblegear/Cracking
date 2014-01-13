/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
*/

/*
This provides a good thought for calculating some accumulative value.
Scan from both sides (left and right) and keep record of the lhs/rhs value in arrays.
*/

public class Solution {
    public int trap(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int length = A.length;
		 if(length <= 2)
			 return 0;
		 int lhs = 0, rhs = length - 1;
		 while((lhs + 1) < length)
		 {
			 if(A[lhs + 1] >= A[lhs])
				 lhs++;
			 else break;
		 }
		 while(rhs > 0)
		 {
			 if(A[rhs - 1] >= A[rhs])
				 rhs--;
			 else break;
		 }
		 int[] lheight = new int[length];
		 int maxheight = A[lhs];
		 for(int i = lhs + 1; i < rhs; i++)
		 {
			 lheight[i] = maxheight;
			 if(A[i] > maxheight)
				 maxheight = A[i];
		 }
		 maxheight = A[rhs];
		 int res = 0;
		 for(int i = rhs - 1; i > lhs; i--)
		 {
			 int minheight = Math.min(maxheight, lheight[i]);
			 if(minheight > A[i])
				 res += minheight - A[i];
			 if(A[i] > maxheight)
				 maxheight = A[i];
		 }
		 lheight = null;
		 return res;
        
    }
}