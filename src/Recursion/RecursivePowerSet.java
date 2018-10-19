package Recursion;

import java.util.ArrayList;

public class RecursivePowerSet {
	
	
	private ArrayList<ArrayList<Integer>> getPowerSet(ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> powerSet = new ArrayList<ArrayList<Integer>>();
		int n = set.size();
		powerSet = getPowerSet(set, n);
		return powerSet;
	}

	private ArrayList<ArrayList<Integer>> getPowerSet(ArrayList<Integer> set, int n) {
		ArrayList<ArrayList<Integer>> powerSet = new ArrayList<ArrayList<Integer>>();
		if(n==0) {
			ArrayList<Integer> arr = new ArrayList<>();
			//arr.add(-1);
			powerSet.add(arr);
			return powerSet;
		}else{
			ArrayList<ArrayList<Integer>> oneSmallerPowerSet = getPowerSet(set, n-1);
			ArrayList<ArrayList<Integer>> moreSets = new ArrayList<ArrayList<Integer>>();
			for(int i=0; i<oneSmallerPowerSet.size(); i++) {
				ArrayList<Integer> temp = new ArrayList<>();
				temp.addAll(oneSmallerPowerSet.get(i));
				temp.add(set.get(n-1));
				moreSets.add(temp);
			}
			oneSmallerPowerSet.addAll(moreSets);
			return oneSmallerPowerSet;
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RecursivePowerSet obj = new RecursivePowerSet();
		ArrayList<Integer> set = new ArrayList<>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(5);
		ArrayList<ArrayList<Integer>> powSet = obj.getPowerSet(set);
		for(int i=0; i<powSet.size(); i++) {
			System.out.print("{ ");
			for(int j=0; j<powSet.get(i).size(); j++) {
				System.out.print(powSet.get(i).get(j) + ", ");
			}
			System.out.println(" }");
		}
		

	}

}
