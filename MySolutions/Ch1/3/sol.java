public class sol {
	public static void main(String[] args) {
		String[] strArr = {"apple", "papel", "columbia", "coumbia",
			"asdfgh", "ashrre"};
		
		Permutation p1 = new Permutation(strArr[0], strArr[1]);
		Permutation p2 = new Permutation(strArr[2], strArr[3]);
		Permutation p3 = new Permutation(strArr[4], strArr[5]);
	}
}

class Permutation {
	public Permutation(String str1, String str2) {
		boolean flag;
		char[] s1 = str1.toCharArray();
		char[] s2 = str2.toCharArray();

		java.util.Arrays.sort(s1);
		java.util.Arrays.sort(s2);

		flag = checkPermut(s1, s2);

		System.out.println("Strings: " + str1 + ", " + str2);
		System.out.println("Permutation? " + flag);
	}

	public boolean checkPermut(char[] s1, char[] s2) {
		if(s1.length != s2.length)
			return false;

		for(int i = 0; i < s1.length; i++) {
			if(s1[i] != s2[i])
				return false;
		}

		return true;
	}
}

/*
Also this can be done with count sort.

When using count sort, should pay attention to the number of buckets and the
number of elements in each bucket
*/
