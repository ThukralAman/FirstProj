package aman.syntaxCheck;

import java.util.Scanner;

public class Solution {
	 public static void main(String[] args) {
	       /* int i = 4;
	        double d = 4.0;
	        String s = "HackerRank ";
			
	        Scanner scan = new Scanner(System.in);
	         Declare second integer, double, and String variables. 
	        int j;
	        double e;
	        

	         Read and save an integer, double, and String to your variables.
	           j = scan.nextInt();
	           e = scan.nextDouble();
	           scan.nextLine();
	           String t = scan.nextLine();
	         Print the sum of both integer variables on a new line. 
	            System.out.println(j+i);
	         Print the sum of the double variables on a new line. 
			    System.out.println(d+e);
	         Concatenate and print the String variables on a new line; 
	        	the 's' variable above should be printed first. 
	            System.out.println(t);
	            scan.close();
	            
	            String myString = "This\nkk.";
	            //String p = new String({'a', 'h','k'});
	            System.out.println(myString);
	            char[] myCharArray = myString.toCharArray();
	            System.out.println(myCharArray.length);
	            for(int k = 0; k < myString.length(); k++){
	            	
	                // Print each sequential character on the same line
	                System.out.print(myCharArray[k]); 
	            }
	            // Print a newline
	            System.out.println(); 
	            */
		 
		 
		 Scanner scanInt = new Scanner(System.in);
	        Scanner scan = new Scanner(System.in);
	        int n = scanInt.nextInt();
	        
	        scanInt.nextLine();
	        
	        
	        
	        
	        
	        
	        for(int i=0; i<n; i++) {
	            String str = scanInt.nextLine();
	            int resultLength = str.length() + 1;
	            char result[] = new char[(str.length())+10];
	            int l=0,m=0;
	            char even[] = new char[10], odd[] = new char[10];
	            char charArr[] = str.toCharArray();
	            for(int j=0; j<charArr.length; j=j+2) {
	                result[l++] = charArr[j];   
	            }
	            result[l++] = ' ';
	            for(int j=1; j<charArr.length; j=j+2) {
	                result[l++] = charArr[j];
	            }
	            System.out.println(result);
	            /*for(int j=0; j<charArr.length; j++) {
	                if(j%2 == 0) {
	                    even[l] = charArr[j];
	                    l++;
	                }
	                else {
	                    odd[m] = charArr[j];
	                    m++;
	                }
	            }
	            System.out.print(even);
	            System.out.print(" ");
	            System.out.print(odd);
	            System.out.println("");*/
	        }
		
	            
	    }
	}

