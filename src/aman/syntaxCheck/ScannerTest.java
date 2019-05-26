package aman.syntaxCheck;

import java.util.Scanner;

public class ScannerTest {
	public static void main(String args[]) {
		Scanner sc =new Scanner(System.in);
		
		int i = sc.nextInt();
		int p = sc.nextInt();
		String q = sc.nextLine();
		/*
		 * next() can read the input only till the space. It can't read two words separated by space. Also, next() places
		 * the cursor in the same line after reading the input. nextLine() reads input including space between the words
		 * (that is, it reads till the end of line \n).Mar 17, 2014
		 */
		 String j = sc.next();
		 
		//String j = sc.next();
		 String k = sc.nextLine();
		System.out.println("i = " + i);
		System.out.println("p = " + p);
		System.out.println("q = " + q);
		System.out.println("j = " + j);
		System.out.println("k = " + k);
		
		Integer e;
	}

}
