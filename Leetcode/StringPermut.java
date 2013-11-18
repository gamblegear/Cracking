import java.util.ArrayList;

public class StringPermut {
	public static void main(String[] args) {
		Permutation pert = new Permutation();
		
		ArrayList<String> list;
		
		list = pert.permute("abc");
		
		for(String s: list)
			System.out.println(s);
	}
}

class Permutation {
	public ArrayList<String> permute(String str) {
		if(str == null)
			return null;
		
		ArrayList<String> allPermut = new ArrayList<String>();
		
		if(str.length() == 0) {
			allPermut.add("");
			return allPermut;
		}
		
		char first = str.charAt(0);
		ArrayList<String> subPermut = permute(str.substring(1));
		
		for(String subString: subPermut) {
			for(int i = 0; i <= subString.length(); i++) {
				String newStr = insertCharAt(subString, first, i);
				allPermut.add(newStr);
			}
		}
		allPermut.addAll(subPermut);

		return allPermut;
	}
	
	public String insertCharAt(String str, char c, int i) {
		return (str.substring(0, i) + c + str.substring(i));
	}
}
