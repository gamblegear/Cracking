/*
Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.
For example:
Given a binary tree {1,2,3,4,5},
    1
   / \
  2   3
 / \
4   5
return the root of the binary tree [4,5,2,#,#,3,1].
   4
  / \
 5   2
    / \
   3   1  

*/

public class Solution {
    public TreeNode UpsideDownBinaryTree(TreeNode root) {
        if(root == null)
            return null;        
    
        Stack<TreeNode> stack = new Stack<TreeNode>();        
        TreeNode node = root;
        while(node != null) {
            stack.push(node);
            node = node.left;
        }

        TreeNode newRoot = buildTree(stack);

        return newRoot;
    }

    private TreeNode buildTree(Stack<TreeNode> stack) {
        TreeNode root = stack.pop();
        TreeNode rightRoot = root;
        TreeNode node = null;
        
        while(!stack.isEmpty()) {
            node = stack.pop();

            if(node.right != null)
                rightRoot.left = node.right;            
            
            rightRoot.right = node;            
            node.left = null;
            node.right = null;

            rightRoot = node;
        }

        return root;
    }
}
