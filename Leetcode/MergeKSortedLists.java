// To handle K sorted problems, think of making use of PriorityQueue.
// Also, the comparator implementation should have a ";" in the end.

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
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        int len = lists.size();
        if(len == 0)
            return null;
        if(len == 1)
            return lists.get(0);
        
        ListNode h = new ListNode(Integer.MIN_VALUE);
        ListNode head = h;
        Queue<ListNode> queue = new PriorityQueue<ListNode>(len, LIST_COMPARE);
        
        for(int i = 0; i < len; i++) {
            if(lists.get(i) != null) {
                queue.add(lists.get(i));
            }
        }
        
        while(!queue.isEmpty()) {
            ListNode temp = queue.poll();
            h.next = temp;
            h = h.next;
            if(temp.next != null) {
                queue.add(temp.next);
            }
        }
        
        return head.next;
    }
    
    static final Comparator<ListNode> LIST_COMPARE = new Comparator<ListNode>() {
        public int compare(ListNode n1, ListNode n2) {
            return (int) (n1.val - n2.val);
        }
    };
}