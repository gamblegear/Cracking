public class ReverseList {
	public static void main(String[] args) {
		//to be implemented
	}
}

class Revertion {
	//the 3 pointer method
	public Node reverse_1(LinkedListNode head) {
		if(head == null || head.next == null)
			return head;

		Node p = head;
		Node q = p.next;
		Node r;
		head.next = null;

		//include the evaluable of r in bracket
		while(q) {
			r = q.next;
			q.next = p;
			p = q;
			q = r;
		}

		head = p;
		return head;
	}

	//the rotation method
	public Node reverse_2(LinkedListNode head) {
		if(head == null || head.next == null)
			return head;

		Node runner;
		Node current;
		runner = head.next;

		while(runner.next) {
			current = runner.next;
			runner.next = current.next;
			current.next = head.next;
			head.next = current;
		}

		runner.next = head;
		head = head.next;
		runner.next.next = null;

		return head;
	}
}
