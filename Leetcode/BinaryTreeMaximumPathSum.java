/*
Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
*/

/*
There are two situations for the maximum: one is the left/right child of the root;
another is the path through the root itself.

Need to keep track of two numbers, one is the max value including the current node,
another is the max value under this node. We will keep the first one as passing
value and the max value in the hashMap.

Also, if this 
*/

public class Solution {
    public int maxPathSum(TreeNode root) {
        HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        map.put(null, Integer.MIN_VALUE);
        //put the null key is critical because if the root if null, the map would
        //have no value for this null key(root).

        getMaxPath(root, map);
        
        return map.get(root);
    }
    
    public int getMaxPath(TreeNode root, HashMap<TreeNode, Integer> map) {
        if(root == null)
            return 0;
        
        int left = getMaxPath(root.left, map);
        int right = getMaxPath(root.right, map);
        
        int childSum = Math.max(map.get(root.left), map.get(root.right));
        int selfSum = root.val + Math.max(left, 0) + Math.max(right, 0);
        
        map.put(root, Math.max(childSum, selfSum));
        
        return Math.max(0, Math.max(left, right)) + root.val;
    }
}