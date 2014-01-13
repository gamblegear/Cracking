/*
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
*/

/*
The idea is to find the available "next" treeNode to connect to.
Also, when recursing, we should proceed the right child first and then the left child.
*/

public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        
        TreeLinkNode current = root.next;
        TreeLinkNode p = null;
        
        while(current != null) {
            if(current.left != null) {
                p = current.left;
                break;
            }
            if(current.right != null) {
                p = current.right;
                break;
            }
            current = current.next;
        }
        
        if(root.right != null)
            root.right.next = p;
            
        if(root.left != null)
            root.left.next = (root.right != null? root.right: p);

        connect(root.right);
        connect(root.left);
    }
}