public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        ListNode last = mid;
        ListNode pre = null;
        while(last != null){
            ListNode next = last.next;
            last.next = pre;
            pre = last;
            last = next;
        }
        slow.next = null;

        while(head != null && pre != null){
            ListNode next1 = head.next;
            head.next = pre;
            pre = pre.next;
            head.next.next = next1;
            head = next1;
        }
    }
}
