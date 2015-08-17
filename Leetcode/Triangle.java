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

//jiuzhang
//Version 1: Bottom-Up
public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        int n = triangle.size();
        int[][] sum = new int[n][n];

        for (int i = 0; i < n; i++) {
            sum[n - 1][i] = triangle.get(n - 1).get(i);
        }

        for (int i = n - 2; i >= 0; i--) { 
            for (int j = 0; j <= i; j++) {
                sum[i][j] = Math.min(sum[i + 1][j], sum[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }

        return sum[0][0];
    }
}


//Version 2 : Memorize Search
public class Solution {
    private int n;
    private int[][] minSum;
    private ArrayList<ArrayList<Integer>> triangle;

    private int search(int x, int y) {
        if (x >= n) {
            return 0;
        }

        if (minSum[x][y] != Integer.MAX_VALUE) {
            return minSum[x][y];
        }

        minSum[x][y] = Math.min(search(x + 1, y), search(x + 1, y + 1))
            + triangle.get(x).get(y);
        return minSum[x][y];
    }

    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        this.n = triangle.size();
        this.triangle = triangle;
        this.minSum = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                minSum[i][j] = Integer.MAX_VALUE;
            }
        }

        return search(0, 0);
    }
} 


//Version 3 : (Time Limit Exceed) Up-Bottom Update
public class Solution {
    private int n;
    private int[][] minSum;
    private ArrayList<ArrayList<Integer>> triangle;

    private void search(int x, int y, int sum) {
        if (x >= n) {
            return;
        }
        if (sum + triangle.get(x).get(y) >= minSum[x][y]) {
            return;
        }
        minSum[x][y] = sum + triangle.get(x).get(y);

        search(x + 1, y, minSum[x][y]);
        search(x + 1, y + 1, minSum[x][y]);
    }

    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        this.n = triangle.size();
        this.triangle = triangle;
        this.minSum = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                minSum[i][j] = Integer.MAX_VALUE;
            }
        }

        search(0, 0, 0);

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            answer = Math.min(answer, minSum[n-1][i]);
        }
        return answer;
    }
}
