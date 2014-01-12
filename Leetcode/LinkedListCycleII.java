/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Follow up:
Can you solve it without using extra space?
*/

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
            return null;
        
        ListNode walker = head;
        ListNode runner = head;
        boolean meet = false;
        
        while(runner != null) {
            walker = walker.next;
            runner = (runner.next == null? runner.next: runner.next.next);
            
            if(walker == runner && walker != null && runner != null) {
                meet = true;
                break;
            }
        }
        
        if(meet == false)
            return null;
        
        walker = head;
        while(walker != runner) {
            walker = walker.next;
            runner = runner.next;
        }
        return walker;
    }
}