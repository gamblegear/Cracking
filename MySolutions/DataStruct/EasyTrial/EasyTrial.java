public class EasyTrial {
	public static void main(String[] args) {
		MinMax minMax = new MinMax();
		minMax.returnMin();
	}
}

class MinMax {
	private int min;
	private int max;

	public void returnMin() {
		min = (5 > 8? 5: 8);
		System.out.println(min);
	}
}
