package NestedClasses;



class MyOuterClass {
	private int test=0;
	
	static void OuterStaticMethod() {
		System.out.println("Hi!! This is a static method in outer class!!");
	}
	
	void callStaticNestedClassMethod() {
		/*
		 * Outer class can access static inner class by creating its object
		 */
		MyStaticNestedClass obj = new MyStaticNestedClass();
		// accessing non static method of static inner class via its object
		obj.staticNestedClassMethod();
		
		// accessing static part of static inner class using class name
		System.out.println(MyStaticNestedClass.t);
	}
	
	/* static Inner Class */
	public static class MyStaticNestedClass {
		
		// Static declaration is allowed in static inner class
		static int t  = 10;
		
		void staticNestedClassMethod() {
			System.out.println("Hi!! This is static nested class method");
			
			//  Static Nested class can access static methods of outer class 
			OuterStaticMethod();
			
			//To access instance fields and methods of outer class static inner class needs to create object of outer class
			MyOuterClass obj = new MyOuterClass();
			System.out.println(obj.test);
		}
		
	}
	
}

public class LearnStaticNestedClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyOuterClass.MyStaticNestedClass obj = new MyOuterClass.MyStaticNestedClass();
		obj.staticNestedClassMethod();
		
		MyOuterClass obj1 = new MyOuterClass();
		obj1.callStaticNestedClassMethod();

	}

}
