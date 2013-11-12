// hashMap way
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        int[] ret = new int[2];
        
        for(int i = 0; i < numbers.length; i++) {
            if(hashMap.containsKey(target - numbers[i])) {
                ret[0] = hashMap.get(target - numbers[i]) + 1;
                ret[1] = i + 1;
                return ret;
            } else {
                hashMap.put(numbers[i], i);
            }
        }
        
        return ret;
    }
}
