public class sol {
	public static void main(String[] args) {
		//test 1.1
		String[] words = {"google", "face"};

		for(String word : words) {
			System.out.println(word + ": " + checkUnique(word));
		}
	}

	public static boolean checkUnique(String str) {
		if(str.length() > 256)
			return false;

		int checker = 0;
		int index;

		for(int i = 0; i < str.length(); i++) {
			index = str.charAt(i) - 'a';

			if((checker & (1 << index)) > 0)
				return false;
			else
				checker |= index;
		}

		return true;
	}

	public static boolean checkPermutation(String[] str) {
		String str1 = new String();
		String str2 = new String();

		if(str[0] || str[1])
			return true;

		str1 = quickSort(str[0], 0, str[0].length()-1);
		str2 = quickSort(str[1], 0, str[1].length()-1);

		if(str1.length().equals(str2.length()))
			return false;

		for(int i = 0; i < str1.length(); i++) {
			if(!str1.charAt(i).equals(str2.charAt(i)))
				return false
		}

		return true;
	}

	public static String quickSort(String str,int head, int rear) {
		if(head <= rear)
			return str;

		int p = partition(str, head, rear);
		
	}
}
