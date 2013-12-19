// LinkedList needs to condider the recursive method.
// Think about the last edge cases and only deal with the first several nodes

/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        
        ListNode ln = swapPairs(head.next.next);
        ListNode res = head.next;
        res.next = head;
        head.next = ln;
        
        return res;
    }
}