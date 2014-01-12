/*
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
*/

public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;
        
        ListNode walker = head;
        ListNode runner = head;
        
        while(runner != null) {
            walker = walker.next;
            runner = (runner.next == null? runner.next: runner.next.next);
            
            if(walker != null && runner != null && walker == runner)
                return true;
        }
        
        return false;
    }
}