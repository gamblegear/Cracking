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

// if this is the merge k sorted list, then need to use a loop, and deal
// with two sorted list each time until all lists are merger.
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        

        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        ListNode node = new ListNode(Integer.MIN_VALUE);
        ListNode head = node;
	// keep head, rather than node.next       
 
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
		// no need to create new node
                node.next = l1;
                l1 = l1.next;
                node = node.next;
            } else {
                node.next = l2;
                l2 = l2.next;
                node = node.next;
            }
        }
        
        while(l2 != null) {
            node.next = l2;
            l2 = l2.next;
            node = node.next;
        }
        
        while(l1 != null) {
            node.next = l1;
            l1 = l1.next;
            node = node.next;
        }
        
	// should return head.next rather than head
        return head.next;
    }
}
