// there are two versions of this problem and the first one is harder
// the second one is easier to understand

public class Solution {
    public int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if(num.length==3) return num[0]+num[1]+num[2];
        
        int j = num.length-1;
        int p;
        int min = Integer.MAX_VALUE;
        int result=0;
        
        for(int k=num.length-1; k>1; k--){
            for(int i=0; i<num.length-k; i++){
                p = i+1;
                j = i+k;
                while(p<j){
                    int temp = num[i]+num[p]+num[j];
                    if(Math.abs(temp-target)<min){
                        min = Math.abs(temp-target);
                        result = temp;
                    }
                    p++;
                }
            }
        }
        
        return result;
        
    }
}

// This is the easier version and borrow the same thinking routine in 3Sum

public int threeSumClosest(int[] num, int target) {
    if (num.length<3) { // if less than three items then return 0
        return Integer.MAX_VALUE;
    }
    Arrays.sort(num);
    int res = num[0]+num[1]+num[2];
    for (int i=0; i<num.length-2; ++i) {
        if (i>0 && num[i]==num[i-1])  continue;
        int start = i+1, end = num.length-1;
        while (start<end) {
            int sum = num[i] + num[start] + num[end];
            if (Math.abs(sum-target) < Math.abs(res-target)) {
                res = sum;
            }
            if (sum == target) {
                return res;
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }//end-while
    }
    return res;
}
