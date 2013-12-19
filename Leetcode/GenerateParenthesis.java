/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
*/

// Judge the loop termination conditions
// Separarte the situation into left and right to consider.

public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        ArrayList<String> result = new ArrayList<String>();
        String str = "";
        
        getParentheses(n, n, str, result);
        return result;
    }
    
    public void getParentheses(int left, int right, String str, ArrayList<String> result) {
        if(left == 0 && right == 0) {
            result.add(str);
            return;
        }
        
        if(left == 0) {
            getParentheses(0, right-1, str+")", result);
        } else if(left > 0) {
            getParentheses(left-1, right, str+"(", result);
            if(right > left)
                getParentheses(left, right-1, str+")", result);
        }
    }
}