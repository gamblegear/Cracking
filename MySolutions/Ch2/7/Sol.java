public class Sol {
	public static void main(String[] args) {
		//
	}
}

class Result {
	LinkedNode node;
	boolean rst;
}

class Palindrome {
	public Result isPalindrome(LinkedNode head, int length) {
		if(length == 0 || head == null)
			return (new Result(null, true));
		else if(length == 1)
			return (new Result(head.next, true));
		else if(length == 2)
			return (new Result(head.next.next,
						head.data == head.next.data));

		Result res = isPalindrome(head.next, length - 2);

		// the real action is as below
		if(res.rst == false || res.node == null)
			return res;
		else {
			res.rst = (head.data == res.node.data);
			res.node = res.node.next;
			return res;
		}
	}

	public boolean pldResult(LinkedNode head) {
		Result p = isPalindrome(head, len(head));
		return p.rst;
	}
}
