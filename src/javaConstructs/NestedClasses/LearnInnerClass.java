package javaConstructs.NestedClasses;


class MyOuterClass1 {
	private int test=0;
	
	private void privateOuterClassMethod1() {
		System.out.println("privateOuterClassMethod1 called");
		
	}
	
	class MyInnerClass1 {
		private int t=0;
		
		void innerClassMethodOne() {
			System.out.println("InnerClassMethodOne called");
			
			// access to private instance field and method of outer class
			System.out.println(++test);
			privateOuterClassMethod1();
		}
	}
	
}

public class LearnInnerClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyOuterClass1 outer = new MyOuterClass1(); 
		MyOuterClass1.MyInnerClass1 obj = outer.new MyInnerClass1();
		obj.innerClassMethodOne();
		
	}

}
