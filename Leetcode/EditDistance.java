/*
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
*/

/*
This is another typical example of 2D DP. Very similar to LCS.
So, think about DP when need to deal with the two string problems.

EditDistance is to find the minimum distance while LCS is to find the longest distance.
*/

public class Solution {
    public int minDistance(String word1, String word2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int len1 = word1.length()+1;
        int len2 = word2.length()+1;
        
        int[][] mat = new int[len1][len2];
        
        for(int i=0; i<len2; i++){
            mat[0][i] = i;
        }
        
        for(int i=0; i<len1; i++){
            mat[i][0] = i;
        }
        
        for(int i=1; i<len1; i++)
            for(int j=1; j<len2; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    mat[i][j] = mat[i-1][j-1];
                }
                else{
                    mat[i][j] = Math.min(mat[i-1][j-1],Math.min(mat[i-1][j], mat[i][j-1]))+1;
                }
            }
        
        return mat[len1-1][len2-1];
    }
}



/*
This is Longest Common Subsequence
*/

/*************************************************************************
 *  Compilation:  javac LCS
 *  Execution:    java LCS < example10.txt
 *  Dependencies: StdIn.java
 *  
 *  Reads in two strings from stdin and computes their longest
 *  common subsequence.
 *
 *************************************************************************/

public class LCS {

    public static void main(String[] args) {
        String x = StdIn.readString();
        String y = StdIn.readString();
        int M = x.length();
        int N = y.length();

        // opt[i][j] = length of LCS of x[i..M] and y[j..N]
        int[][] opt = new int[M+1][N+1];

        // compute length of LCS and all subproblems via dynamic programming
        for (int i = M-1; i >= 0; i--) {
            for (int j = N-1; j >= 0; j--) {
                if (x.charAt(i) == y.charAt(j))
                    opt[i][j] = opt[i+1][j+1] + 1;
                else 
                    opt[i][j] = Math.max(opt[i+1][j], opt[i][j+1]);
            }
        }

        // recover LCS itself and print it to standard output
        int i = 0, j = 0;
        while(i < M && j < N) {
            if (x.charAt(i) == y.charAt(j)) {
                System.out.print(x.charAt(i));
                i++;
                j++;
            }
            else if (opt[i+1][j] >= opt[i][j+1]) i++;
            else                                 j++;
        }
        System.out.println();

    }

}
