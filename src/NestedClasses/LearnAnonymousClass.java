package NestedClasses;

class SuperClass {

	  public void doIt() {
	    System.out.println("SuperClass doIt()");
	  }

	}

interface MyInterface {

	  public void doIt();

	}



public class LearnAnonymousClass {
	
	private int test=1;
	
	void testAnonymousSubClass() {
		/*
		 *  - Running this Java code would result in Anonymous class doIt() being printed to System.out. 
		 *    The anonymous class subclasses (extends) SuperClass and overrides the doIt() method.
		 *    
		 *  - An anonymous class can access members of the enclosing class. It can also access 
		 *  local variables which are declared final or effectively final 
		 */
		final int localVar=55;
		SuperClass instance1 = new SuperClass() {

		    public void doIt() {
		    	System.out.println(localVar);
		    	System.out.println(++test);
		        System.out.println("Anonymous class doIt()");
		    }
		};

		instance1.doIt();
	}
	
	void testAnonymousInterfaceClass() {
		/* - As you can see, an anonymous class implementing an interface is 
		 * pretty similar to an anonymous class extending another class.
		 * 
		 *  - An anonymous class can access members of the enclosing class. It can also access 
		 * local variables which are declared final or effectively final 
		 */
		MyInterface instance2 = new MyInterface() {

		    public void doIt() {
		    	System.out.println(++test);
		        System.out.println("Anonymous class implementing Interface doIt()");
		    }
		};

		instance2.doIt();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LearnAnonymousClass obj = new LearnAnonymousClass();
		
		
		obj.testAnonymousSubClass();
		obj.testAnonymousInterfaceClass();
	}
	

	
	

}
