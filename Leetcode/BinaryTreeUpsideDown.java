// this is sz's solution - will be tested
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

    private TreeNode newRoot(Stack<TreeNode> stack) {
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

// this is recursive
public TreeNode UpsideDownBinaryTree(TreeNode root) {  
    if (root == null)  
        return null;  
    TreeNode parent = root, left = root.left, right = root.right;  
    if (left != null) {  
        TreeNode ret = UpsideDownBinaryTree(left);  
        left.left = right;  
        left.right = parent;  
        return ret;  
    }  
    return root;  
}  

    1                 4   1
   / \               / \ / \
  2   3      -->    5   2   3
 / \
4   5
