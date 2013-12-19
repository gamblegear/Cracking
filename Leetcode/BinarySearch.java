public class BinarySearch{
	public static void main(String[] args) {
		Binary bSearch = new Binary(Integer.parseInt(args[0]));
	}
}

class Binary {
	int target;
	int[] array;

	public Binary(int num) {
		this.target = num;
		int[] arrays = {0,9,11,3,41,5,22,86,19};
		array = arrays;

		search();
	}

	public void search() {
		int low = 0;
		int high = this.array.length-1;
		int mid;

		while(low <= high) {
			mid = low + (high-low)/2;
			if(array[mid] > target)
				high = mid-1;
			else if(array[mid] < target)
				low = mid+1;
			else {
				System.out.println("target place: " + mid);
				return;
			}
		}

		System.out.println("target place not found");
		return;
	}
}