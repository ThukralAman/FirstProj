package aman.syntaxCheck;import java.util.HashSet;
import java.util.Set;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

public class TestInheritance {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] names = { "Java", "JavaScript", "Python", "C", "Ruby", "Java" };
		
		B obj = new B();
		
		if( obj instanceof B) {
			System.out.println("obj is instance of B");
		}else {
			System.out.println("obj not instance of B");
		}
		
		if(obj instanceof C) {
			System.out.println("obj instance of C interface");
		}else {
			System.out.println("obj not instance of C interface");
		}
		
		if(obj instanceof A) {
			System.out.println("obj instanvce of A");
		}else {
			System.out.println("NOT instance of A");
		}
		
		
		System.out.println("Duplicate elements from array using HashSet data structure"); 
		Set<String> store = new HashSet<>(); 
		for (String name : names) { 
			if (store.add(name) == false) { 
				System.out.println("found a duplicate element in array : " + name); 
			}
		}
		
		System.out.println("set = " + store);
		
		if(WeekDay.MONDAY.name().equals("MONDAY")) {
			System.out.println("Name test passed");
		}else {
			System.out.println("Name Test faled");
		}
		

	}
	
	
	public <T extends C> T testGenericMethod() {
		C obj = new B();
		obj.printAnything();
		
		return (T)obj;
	}
	
	enum WeekDay {
	    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY;

	    public String toString() {
	        return name().charAt(0) + name().substring(1).toLowerCase();
	    }
	}

}



class A {
	int a=10;
	String[] names = { "Java", "JavaScript", "Python", "C", "Ruby", "Java" };

	
	
	void geta( ) {
		System.out.println("a = " + a);
	}
	
}



class B extends A implements C {
	int b = 20;
	
	void getb() {
		System.out.println("b =  " + b);
	}

	@Override
	public void printAnything() {
		System.out.println("B printing anything for interface C");
		
	}
}

interface C {
	public static int c = 10;
	
	void printAnything();
	
}


