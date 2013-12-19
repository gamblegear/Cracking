public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if (n == 0)
            return;
            
        if (m == 0) {
            for (int i = 0; i < n; i++)
                A[i] = B[i];
            return;
        }
        
        int length = m + n;
        for (int i = length - 1; i >=0; i--) {
            if (n==0)
                return;
            
            if (m == 0 || A[m-1] < B[n-1]) {
                A[i] = B[n-1];
                n--;
            }
            else {
                A[i] = A[m-1];
                m--;
            }
        }
    }
}