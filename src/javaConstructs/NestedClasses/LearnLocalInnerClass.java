package javaConstructs.NestedClasses;

/*
 *  - - - - http://tutorials.jenkov.com/java/nested-classes.html - - - - 
 * 
 *  - Local classes can only be accessed from inside the method or scope block in which they are defined.
 *  - Local classes can access members (fields and methods) of its enclosing class just like regular inner classes
 *  - Local classes can also access local variables inside the same method or scope block, provided these variables are declared final
 *  - Local classes can also be declared inside static methods
 */

class MyOuterClass2 {
	private int test=0;
	
	void outerClassMethod2() {
		System.out.println("Outer class method called!!");
	}
	
	public void outerClassMethod1() {
		class MyLocalInnerClass {
			private int localClassField = 0;
			
			void localClassMethod1() {
				System.out.println("Local Class Method called!!");
				System.out.println("Local Class Method calling Local Class Method2()");
				outerClassMethod2();
				
				System.out.println(++test);
			}
		}
		
		MyLocalInnerClass local = new MyLocalInnerClass();
		local.localClassMethod1();
	}
}

public class LearnLocalInnerClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyOuterClass2 outer = new MyOuterClass2();
		outer.outerClassMethod1();
	}

}
