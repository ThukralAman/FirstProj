package aman.syntaxCheck;

import java.util.ArrayList;
import java.util.Arrays;

public class TestArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] a = {1,2,3,4,5};
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));//new ArrayList<Integer>();
		
		//arr.add(0,9);
		System.out.println(arr.subList(0, 1));

	}

}
