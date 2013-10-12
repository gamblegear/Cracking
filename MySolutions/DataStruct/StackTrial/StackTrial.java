import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.Stack;

public class StackTrial {
	public static void main(String[] args) {
		Operations oper = new Operations();
		oper.test();
	}
}

class Operations {
	private ArrayList<Integer> aList = new ArrayList<Integer>();
	private Stack<Integer> stack = new Stack<Integer>();
	
	public void test() {
		Random rand = new Random();
		int num;
		int output;
		
		int counter = 0;
		
		for(int i = 0; i < 10; i++) {
			num = rand.nextInt(10);
			aList.add(num);
			
			System.out.println("** " + num);
		}
		
		Collections.sort(aList);
		
		Iterator<Integer> iter = aList.iterator();
		while(iter.hasNext()) {
			stack.push(iter.next());
			iter.remove();
			
			counter++;
		}
		
		System.out.println("counter: " + counter);
		
		while(!stack.isEmpty()) {
			output = stack.pop();
			//stack.remove(output);
			System.out.println(output);
		}
	}
}
