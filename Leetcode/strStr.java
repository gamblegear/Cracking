
// time complexity for this is O(mn)
// also we can use KMP
public class Solution {
    public String strStr(String haystack, String needle) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        char[] hArr = haystack.toCharArray();
        char[] nArr = needle.toCharArray();
    
        if (nArr.length == 0) {
            return haystack;
        }
    
        for (int i=0; i < hArr.length; i++) {
            if (i + nArr.length > hArr.length) {
                break;
            }
            int k = 0;
            boolean same = true;
            for(int j=i; k < nArr.length; j++, k++) {
                if (hArr[j] != nArr[k]) {
                    same = false;
                    break;
                }
            }
    
            if (same) {
                return haystack.substring(i);
            }
        }
        return null;
    }
}
