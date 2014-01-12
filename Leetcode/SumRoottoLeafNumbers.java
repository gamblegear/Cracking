/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
*/

/*
Recursion in Tree: two kinds of termination conditions:
1. root == null;
2. root.left == null && root.right == null

1. works nicely with "modification of structures", which does not need to return some value
   back to its upper layer of recursion;
2. works with "trace back", which asks to return some value back to its upper layer, so this
   calculation can be finished unifiedly, otherwise, if we do it in its upper layer, we need
   to consider the left child and right child, two conditions.

******************************************************************************************

Keep track of the node's parent:
We can use a HashMap<child, root> to help do the trace back.
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
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        
        HashMap<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        int res = 0;
        
        getSum(root, map, list);
        
        for(int i: list)
            res += i;
        
        return res;
    }
    
    public void getSum(TreeNode root, HashMap<TreeNode, TreeNode> map, ArrayList<Integer> list) {
        if(root.left == null && root.right == null) {
            int subTotal = 0;
            int weight = 1;
            
            while(root != null) {
                subTotal += weight*root.val;
                weight *= 10;
                root = map.get(root);
            }
            
            list.add(subTotal);
            return;
        }
        
        if(root.left != null) {
            map.put(root.left, root);
            getSum(root.left, map, list);
        }
        
        if(root.right != null) {
            map.put(root.right, root);
            getSum(root.right, map, list);
        }
        
    }
}