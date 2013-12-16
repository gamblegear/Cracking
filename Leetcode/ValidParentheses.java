/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

public class Solution {
    public boolean isValid(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if(s.length() == 0)
            return false;
        if(s.length()%2 == 1)
            return false;

	// very important to use stack in symmetric situation            
        Stack<Character> stack = new Stack<Character>();
        char current;
        char previous;
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                stack.push(s.charAt(i));
            else {
                if(stack.isEmpty())
                    return false;
                else if(s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
                    current = s.charAt(i);
                    previous = stack.peek();
                    if(previous == '(' && current == ')')
                        stack.pop();
                    else if(previous == '[' && current == ']')
                        stack.pop();
                    else if(previous == '{' && current == '}')
                        stack.pop();
                    else
                        return false;
                }
            }
        }
        
        if(stack.isEmpty())
            return true;
        else
            return false;
    }
}
