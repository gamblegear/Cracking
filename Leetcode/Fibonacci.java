public class Fibonacci {
	public static void main(String[] args) {
		int arg = Integer.parseInt(args[0]);

		Fib_1 fib_1 = new Fib_1(arg);
		System.out.println("DP way: " + fib_1.calculate(arg));

		Fib_2 fib_2 = new Fib_2();
		System.out.println("Iterative way: " + fib_2.calculate(arg));
	}
}

class Fib_1 {
	int[] value;
	
	public Fib_1(int n) {
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

class Fib_2 {
	public int calculate(int n) {
		if(n == 0)
			return 0;
		if(n == 1)
			return 1;

		int[] res = new int[n+1];

		res[0] = 0;
		res[1] = 1;

		for(int i = 2; i <= n; i++) {
			res[i] = res[i-1] + res[i-2];
		}

		return res[n];
	}
}
