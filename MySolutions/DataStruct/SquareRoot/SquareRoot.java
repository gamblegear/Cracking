import java.Math;

public class SqaureRoot {
	public static void main(String[] args) {
		Square square = new Square(12345);
		square.babylonian();
	}
}

class Square {
	double num;
	double root;

	public Square(double n) {
		this.num = n;
	}

	public double babylonianMethod() {
		double tmp = num;
		int power = 0;

		while(tmp > 100) {
			tmp = tmp / 100;
			power += 2;
		}

		if(tmp < 10)
			root = 2 * 10^(power/2);
		else
			root = 6 * 10^(power/2);

		while(abs(num - root) > 0.001)
			root = (1/2) * (root + num/root);

		return root;
	}
}
