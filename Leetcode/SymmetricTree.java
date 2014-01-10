/*
Symmetric Tree Total Accepted: 6029 Total Submissions: 18622 My Submissions
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
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
    public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root== null) return true;
        return ifSymmetric(root.left, root.right);        
    }

    public boolean ifSymmetric(TreeNode tree1, TreeNode tree2){
            if(tree1==null && tree2==null)
                return true;
            else if(tree1 == null || tree2 == null)
                return false;
            
            if(tree1.val != tree2.val)
                return false;
            else
                return (ifSymmetric(tree1.left, tree2.right) && ifSymmetric(tree1.right, tree2.left));
    }
}