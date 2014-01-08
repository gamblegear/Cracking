/*
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
*/

/*
Using the iterative way to traverse needs certain data structure.
1. Structure that can be used to store information: Queue and Stack.
2. Think about the inner logic of the visiting order of Stack.
3. Need to put the poped element into a new stack, the new stack can be replaced
   with an arraylist which puts the new element in the beginning of the arraylist.
*/



/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// This is the method that only uses one stack.
public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        if(root == null)
            return al;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.left != null)
                stack.push(node.left);
            if(node.right != null)
                stack.push(node.right);
            al.add(0, node.val);
        }
        
        return al;
    }
}

// This is the method that uses two stacks
public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        if(root == null) return al;
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<Integer> stack2 = new Stack<Integer>();
        stack1.push(root);
        while(! stack1.isEmpty()){
            TreeNode node = stack1.pop();
            stack2.push(node.val);
            if( node.left != null ){
                stack1.push(node.left);
            }
            if(node.right!= null){
                stack1.push(node.right);
            }
        }
        while(!stack2.isEmpty()){
            al.add(stack2.pop());
        }    
        return al;
    }
}