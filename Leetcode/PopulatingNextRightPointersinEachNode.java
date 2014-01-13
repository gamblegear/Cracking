/*
Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
*/


//Recursive way
public class Solution {
    public void connect(TreeLinkNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(root == null)
            return;
        
        if(root.left != null)
            root.left.next = root.right;
        
        if(root.right != null)
            root.right.next = (root.next != null? root.next.left: null);
        
        connect(root.left);
        connect(root.right);
    }
}

//Iterative way
public class Solution {
    public void connect(TreeLinkNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(root == null)
            return;
        
        TreeLinkNode currentLev = root;
        TreeLinkNode current = root;
        
        while(true) {
            while(current != null) {
                if(current.left != null) {
                    current.left.next = current.right;
                    if(current.next != null) {
                        current.right.next = current.next.left;
                    }
                }
                current = current.next;
            }
            
            if(currentLev.left != null) {
                currentLev = currentLev.left;
                current = currentLev;
            } else
                return;
        }
    }
}