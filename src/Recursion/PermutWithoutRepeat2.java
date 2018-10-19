package Recursion;

import java.util.ArrayList;

public class PermutWithoutRepeat2 {
	
	
	public ArrayList<String> getPermut(String s) {
		ArrayList<String> res = new ArrayList<>();
		if(s=="" || s.isEmpty()) {
			return res;
		}else if(s.length()==1) {
			res.add(s);
			return res;
		}
		
		for(int i=0; i<s.length(); i++) {
			String temp;
			if(i==s.length()-1) {
				temp = s.substring(0, i);
			}else{
				temp = s.substring(0, i) + s.substring(i+1);
			}
			ArrayList<String> temp1 = getPermut(temp);
			for(String word: temp1) {
				res.add(s.charAt(i) + word);
			}
			
		}
		return res;
	}

	public static void main(String[] args) {
		PermutWithoutRepeat2 obj = new PermutWithoutRepeat2();
		String s = "abc";
		ArrayList<String> res = obj.getPermut(s);
		for(String word : res) {
			System.out.println(word);
		}
	}
}
