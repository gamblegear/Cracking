/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
*/

/*
This is a very typical solution for BFS, which needs to take into consideration of the
actual LEVEL and how many nodes we have on this level. Therefore, we need to keep
record of 1. current; 2. next;

Another approach would be to use two lists/queues. One is used to keep all nodes in the
current level and another is used to keep all nodes in the next level.
Iterate the current list/queue and put all nodes in the next level to the next list/queue.
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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> resList = new ArrayList<ArrayList<Integer>>();
        
        if(root == null)
            return resList;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> level = new ArrayList<Integer>();
        int current = 1;
        int next = 0;
        
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            current--;
            
            if(node != null)
                level.add(node.val);
            if(node.left != null) {
                queue.add(node.left);
                next++;
            }
            if(node.right != null) {
                queue.add(node.right);
                next++;
            }
            
            if(current == 0) {
                resList.add(level);
                level = new ArrayList<Integer>();
                current = next;
                next = 0;
            }
        }
        
        return resList;
    }
}
