package Recursion;

import java.util.ArrayList;
import java.util.Stack;

class Tower {
	String name;
	Stack<Integer> tower;
	
	Tower(String name) {
		this.name = name;
		tower = new Stack<>();
	}
}

public class TowerOfHanoi {
	
	
	public void toh(int n, Tower source, Tower dest, Tower buffer) {
		if(n==0) {
			return;
		}else if(n==1) {
			System.out.println("Moving plate " + source.tower.peek() + " from " + source.name  + " to " + dest.name);
			int temp = source.tower.pop();
			dest.tower.push(temp);
		}else if(n==2) {
			System.out.println("Moving plate " + source.tower.peek() + " from " + source.name + " to " + buffer.name);
			int temp = source.tower.pop();
			buffer.tower.push(temp);
			System.out.println("Moving plate " + source.tower.peek() + " from " + source.name + " to " + dest.name);
			temp = source.tower.pop();
			dest.tower.push(temp);
			System.out.println("Moving plate " + buffer.tower.peek() + " from " + buffer.name + " to " + dest.name);
			temp = buffer.tower.pop();
			dest.tower.push(temp);
		}else{
			toh(n-1, source, buffer, dest);
			System.out.println("Moving plate " + source.tower.peek() + " from " + source.name  + " to " + dest.name);
			int temp = source.tower.pop();
			dest.tower.push(temp);
			toh(n-1, buffer, dest, source);
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TowerOfHanoi obj = new TowerOfHanoi();

		/*ArrayList<ArrayList<Integer>> towers = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<3; i++) {
			ArrayList<Integer> arr = new ArrayList<>();
			towers.add(arr);
		}
		for(int i=3; i>0; i--) {
			towers.get(0).add(i);
		}
		
		System.out.println("TOwers state initially:");
		for(int i=0; i<towers.size(); i++) {
			System.out.print("[");
			for(int j=0; j<towers.get(i).size(); j++) {
				System.out.print(towers.get(i).get(j) + ", ");
			}
			System.out.println("]");
		}
		obj.toh(towers, 0, 1, 2);	*/
		
		/*Stack<Integer> source = new Stack<>();
		Stack<Integer> buffer = new Stack<>();
		Stack<Integer> dest = new Stack<>();*/
		Tower source = new Tower("source"),
				dest = new Tower("dest"),
				buffer = new Tower("buffer");
		
		
		int n=3;
		
		for(int i=n; i>0; i--) {
			source.tower.push(i);
		}
		
		
		obj.toh(n, source, dest, buffer);
		
		
		
	}

}
