/*
draw the chart to help understand:

<1>
a: 3,2,1        b: 

<2>
a:              b: 1,2,3

<3>
a: 4,3,2,1      b: 1,2,3,4

*/

class MyQueue {
    Stack<Integer> sa = new Stack<Integer>();
    Stack<Integer> sb = new Stack<Integer>();
    
     // Push element x to the back of queue.
    public void push(int x) {
        if(sa.isEmpty())
            while(!sb.isEmpty())
                sa.push(sb.pop());
        sa.push(x);
    }
    
    // Removes the element from in front of queue.
    public void pop() {
        if(sb.isEmpty())
            while(!sa.isEmpty())
                sb.push(sa.pop());
        sb.pop();
    }
    
    // Get the front element.
    public int peek() {
        if(sb.isEmpty())
            while(!sa.isEmpty())
                sb.push(sa.pop());
        return sb.peek();
    }
    
    // Return whether the queue is empty.
    public boolean empty() {
        return sa.isEmpty() && sb.isEmpty();
    }
}
