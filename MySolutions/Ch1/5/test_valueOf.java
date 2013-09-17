public class test_valueOf {
	public static void main(String[] args) {
		int i = 234;
		char c;
		String str = new String();

//		c = Character.valueOf(i);
	//	str = String.valueOf(i);
		str = "" + i;

//		System.out.println(c);
		System.out.println(str);
	}
}
