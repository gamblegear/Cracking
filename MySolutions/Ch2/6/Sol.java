public class Sol {
	public void main(String[] args) {
		// to be
	}
}

class CircleNode {
	Node findStart(ListNode head) {
		if(head == null || head.next == null)
			return null;

		// No need to create two new space
		//ListNode slow = new ListNode();
		//ListNode fast = new ListNode();

		slow = head;
		fast = head;

		//while(slow != null && fast.next != null) {
		while(fast.next != null && fast.next.next != null) {
			if(slow == fast)
				break;
			else {
				slow = slow.next;
				fast = fast.next.next;
			}
		}

		slow = head;

		while(slow != null && fast != null) {
			if(slow == fast)
				return fast
			else {
				slow = slow.next;
				fast = fast.next;
			}
		}
	}
}
