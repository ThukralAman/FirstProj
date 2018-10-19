package Recursion;

import java.util.ArrayList;

public class PermutationWithoutRepeat {
	
	
	public ArrayList<String> getPerm(String s) {
		ArrayList<String> res = new ArrayList<>();
		if(s.length()==0) {
			return res;
		}else if(s.length()==1) {
			res.add(s);
			return res;
		}else{
			ArrayList<String> temp = getPerm(s.substring(1));
			for(String word : temp) {
				for(int j=0; j<=word.length(); j++) {
					String temp1 = insertCharAt(j, word, s.charAt(0));
					res.add(temp1);
				}
			}
		}
		
		return res;
	}
	
	public String insertCharAt(int index, String word, Character c ) {
		String beg = word.substring(0, index);
		String end = word.substring(index);
		return beg + c + end;
	}

	public static void main(String[] args) {
		PermutationWithoutRepeat obj = new PermutationWithoutRepeat();
		String s = "abcdefghij";
		ArrayList<String> res = obj.getPerm(s);
		for(int i=0; i<res.size(); i++) {
			System.out.println(res.get(i));
		}
	}
}
