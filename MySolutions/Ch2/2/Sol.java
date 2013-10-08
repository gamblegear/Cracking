public class Sol {
	public static void main(String[] args) {
		//
	}
}

// This is to use the whole wrapper
class RecWrapper {
	int cnt = 0;
	LinkedListNode node;

	public RecWrapper(int n, LinkedListNode node) {
		this.cnt = n;
		this.node = node;
	}
}

// My method of wholeWrapper is not right. Need to consider
class RecCutList_wholeWp {
	public RecWrapper cutList(LinkedListNode head, int k) {
		if(node == null) {
			return new RecWrapper(0, null);
		}

		RecWrapper wrapper = cutList_1(head.next, k, wrapper);
		if(wrapper.node == null) {
			wrapper.cnt += 1;
			if (wrapper.cnt == k)
				wrapper.node = head;
		}

		return wrapper;
	}
}

// The int wrapper method can be found from CtCi solutions. Also need to understand how to use the "temporary" node container to pass the real "node" that it needs

// My version of the Iterative version
class IterCutList {
	public LinkedListNode cutList(LinkedListNode head, int k) {
		if(head == 0 || k == 0)
			return null;

		LinkedListNode runner = head;
		LinkedListNode node = head;
		int counter = 0;

		for(counter; counter < k-1; counter++) {
			if(runner.next != null)
				runner = runner.next;
			else
				return null;
		}

		while(runner != null) {
			runner = runner.next;
			node = node.next;
		}

		return node;
	}
}
