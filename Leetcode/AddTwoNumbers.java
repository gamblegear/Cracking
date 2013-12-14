You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        
        ListNode node = new ListNode(0);
        ListNode head = node;
        int carry = 0;
        
        while((l1 != null) && (l2 != null)) {
            int sum = l1.val + l2.val + carry;
            carry = 0;

            if(sum >= 10) {
                sum = sum - 10;
                carry = 1;
            }
            
            l1 = l1.next;
            l2 = l2.next;
            node.next = new ListNode(sum);
            node = node.next;
        }
        
        while(l1 != null) {
            int sum = l1.val + carry;
            carry = 0;
            
            if(sum >= 10) {
                sum -= 10;
                carry = 1;
            }
            
            l1 = l1.next;
            node.next = new ListNode(sum);
            node = node.next;
        }
        
        while(l2 != null) {
            int sum = l2.val + carry;
            carry = 0;
            
            if(sum >= 10) {
                sum -= 10;
                carry = 1;
            }
            
            l2 = l2.next;
            node.next = new ListNode(sum);
            node = node.next;
        }
        
        if(carry == 1) {
            node.next = new ListNode(1);
            carry = 0;
            node = node.next;
        }
        
        return head.next;
    }
}
