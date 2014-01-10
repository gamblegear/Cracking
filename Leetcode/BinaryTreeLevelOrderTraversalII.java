/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7]
  [9,20],
  [3],
]
confused what "{1,#,2,3}" means?
*/

/*
This is to output the level order from bottom up.
Since we can output from top down, we can just add another stack to store the level
and then output from the bottom part.

Also, here in this approach, we use another way to do level traversal, with no need
to keep track of how many elements we have in each level.
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
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if(root == null)
        	return result;

        Stack<ArrayList<Integer>> stack = new Stack<ArrayList<Integer>>();
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        //Queue<TreeNode> queue = new Queue<TreeNode>();
        //Here why we use ArrayList rather than Queue is because we want to directly
        //add the tmp list to stack/result and we can use ArrayList to resemble the
        //operation we have for Queue.
        
        list.add(root);
        while(!list.isEmpty()) {
            ArrayList<TreeNode> next = new ArrayList<TreeNode>();
            ArrayList<Integer> level = new ArrayList<Integer>();
            
            while(!list.isEmpty()) {
                TreeNode node = list.remove(0);
                level.add(node.val);
                if(node.left != null)
                    next.add(node.left);
                if(node.right != null)
                    next.add(node.right);
            }
            
            stack.push(level);
            list = next;
        }
        
        while(!stack.isEmpty())
            result.add(stack.pop());
        
        return result;
    }
}