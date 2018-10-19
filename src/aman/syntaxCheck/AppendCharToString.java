package aman.syntaxCheck;

/*
 * 
 * You can concatenate float, int, char to string using + operator
 */

public class AppendCharToString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String test = "AppendCharToString";
		char ch = 'A';
		
		test += ch;
		
		System.out.println(test);
		
		test = test + 123.66;
		System.out.println(test);
	}

}
