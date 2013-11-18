public class Fibonacci {
	public static void main(String[] args) {
		// to be implemented
		Fib fib = new Fib(10);
		System.out.println(fib.calculate(10));
	}
}

class Fib {
	int[] value;
	
	public Fib(int n) {
		this.value = new int[n+1];
		
		for(int i = 0; i <= n; i++)
			value[i] = -1;
	}
	
	public int calculate(int n) {
		if(n == 0)
			return 0;
		if(n == 1)
			return 1;
		if(value[n] != -1)
			return value[n];
		
		
		return value[n] = (calculate(n-1) + calculate(n-2));
	}
}
