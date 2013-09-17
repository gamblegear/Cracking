/*
This is tricky! Because you only need to check if "yx" is substring of "xyxy"
*/

// This is just a method
// s1 = waterbottle; s2 = erbottlewat; ss = s1 + s1 = waterbottlewaterbottlewat


public boolean checkRotate(String s1, String s2) {
	if(s1.length != s2.length)
		return false;

	String ss = s1 + s1;
	return ifSubString(s2, ss)
}
