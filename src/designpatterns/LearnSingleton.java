package designpatterns;

/*
 *  How to create a singleton class - A class which allows creation of only one object of that class. 
 *  Eg, Logger class or Webdriver class
 *  
 *  1. Make constructor private - By making constructor private, class is taking away the previlige to create its object fro outside its class
 *  
 *  2. To allow creation of single object and make it available to outside world 
 *  -> create a static method which can be called on className and return an object to outside world
 *  -> acess specifier should be public, so that it can be called from anywhere outside
 *  
 *  3. Now to restrict the object creation limit to one
 *  -> Create an instance reference variable for the object 
 *  -> in the static method check if reference variable for object is set to null, then instantiate object. 
 *  Otherwise return the reference variable with already created reference
 *  -> Now to refer to reference variable from static method the reference variable has to be declared static
 *  
 *  4. Now after making reference variable static, there is danger of any outside object accessing it via className even before it gets initialized via getInstance()
 *  -> for this make reference variable private.
 *  
 */

public class LearnSingleton {

	static private LearnSingleton obj; /* = new LearnSingleton(); */

	private LearnSingleton() {

	}

	public static LearnSingleton getInstance() {
		if (obj == null) {
			obj = new LearnSingleton();
		}
		return obj;
	}

	public static void main(String[] args) {
		Test o1 = new Test();
		o1.testSingleton();
	}

}

class Test {
	void testSingleton() {
		// TODO Auto-generated method stub
		// LearnSingleton o3 = new LearnSingleton();
		LearnSingleton obj1 = LearnSingleton.getInstance();
		LearnSingleton obj2 = LearnSingleton.getInstance();

		if (obj1 == obj2) {
			System.out.println("Object references are same");
		} else {
			System.out.println("Objects are different");
		}

	}

}
