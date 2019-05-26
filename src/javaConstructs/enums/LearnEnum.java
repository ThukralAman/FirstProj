package javaConstructs.enums;

/*
 * 
 *  1. NOTE: Yo cannot declare enum inside method.
 */

/*

	Ref: https://stackoverflow.com/questions/4709175/what-are-enums-and-why-are-they-useful

	Q: When to Use Enums
	A: You should always use enums when a variable (especially a method parameter) can only take one out of a small set
	 of possible values. Examples would be things like type constants (contract status: "permanent", "temp", "apprentice"),
	  or flags ("execute now", "defer execution").

	public enum FB_TYPE {
 		GREEN, WRINKLED, SWEET,
 		special type for all types combined
		ALL;
		}

	public int countFoobangs(FB_TYPE type)

	A method call like:

	int sweetFoobangCount = countFoobangs(3);
	then becomes:

	int sweetFoobangCount = countFoobangs(FB_TYPE.SWEET);

	In the second example, it's immediately clear which types are allowed, docs and implementation cannot go out of sync,
	and the compiler can enforce this. Also, an invalid call like

	int sweetFoobangCount = countFoobangs(99);
	is no longer possible
 */

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

enum Test {
	KEY1(10),
	KEY2(20);

	private int key;
	Test(int key) {
		this.key = key;
	}

	public int getKey() {
		return this.key;
	}
}

enum Test1 {
	KEY1(30),
	KEY2(40);

	private int key;
	Test1(int key) {
		this.key = key;
	}

	public int getKey() {
		return this.key;
	}
}

public class LearnEnum {
	
	public static final LearnEnum le = new LearnEnum();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Coffee d1 = new Coffee();
		Coffee d2 = new Coffee();
		
		
		d1.size = CoffeeSize.BIG;            // enum declared outside class
		d1.type = Coffee.CoffeeType.LATTE;   // enum declared inside class
		d1.container =CoffeeContainer.DECORATED; //  You can NEVER invoke an enum constructor directly
		d1.color = CoffeeColor.GREY;
		
		System.out.println("d1 Size = " + d1.size);
		System.out.println("d1 type = " + d1.type);
		System.out.println("d1 container = " + d1.container);
		System.out.println("d1 container price = " + d1.container.getPrice());
		System.out.println("d1 color = " + d1.color);
		System.out.println("d1 color LidCode= " + d1.color.getLidCode());

		System.out.println("Me----- = " + CoffeeContainer.GLASS.getPrice());
		
		
		for(CoffeeContainer container: CoffeeContainer.values()) {
			System.out.print(container + " ");
			System.out.println(container.getPrice());
		}
		
		d2.color = CoffeeColor.BLACK;
		System.out.println("d2 color LidCode= " + d2.color.getLidCode());

		// Iterate over Enum
		System.out.println("----- Iterating Over ENUM --------------- ");
		le.iterateEnumUsingForEach();
		le.iterateInLoop();

		le.test();
		

	}

	public void iterateEnumUsingForEach() {
		EnumSet.allOf(CoffeeContainer.class)
				.forEach(container -> System.out.println(container));
	}

	public void iterateInLoop() {
		for (CoffeeContainer container : CoffeeContainer.values()) {
			System.out.println(container);
		}
	}

	public void test() {
		/*for (Test k : Test.values()) {
			System.out.println(k);
			System.out.println(Test1.k);
		}*/
		Map<Integer, Integer> hm = new HashMap<>();
		hm.put(1,11);
		Integer val = hm.get(2);
		if(val==null) {
			System.out.println("null returned by hm get()");
		}else {
			System.out.println("null ni mila");
		}

		for(Test k : Test.values()) {
			for(Test1 l : Test1.values()) {
				if(l.equals(k)) {
					System.out.println("matching key " + k + "and " + l);
				}
			}
		}
	}


}

// enum declared outside class
enum CoffeeSize {
	SMALL,
	BIG,
	LARGE,
	OVERWHELMING;
};

enum CoffeeContainer {
	GLASS(10),
	PAPER(2),
	DECORATED(12);
	
	/*
	 *  You can define more than one argument to the constructor, and you can
		overload the enum constructors, just as you can overload a normal class
		constructor. 
	 */
	CoffeeContainer(int price) {
		this.price = price;
	}
	
	private int price;
	
	public int getPrice() {
		return this.price;
	}
}

enum CoffeeColor {
	BLACK,
	BROWN,
	GREY{
		
		// this is sort of over-ride of getLidCode() for GREY type enum constant
		public String getLidCode() {
			return "LidCodeB";
		}
	};
	
	// Assuming all coffee color use LidCodeA except GREY COFFEE
		public String getLidCode() {
			return "LidCodeA";
		}
	
}

class Coffee {
	
	// enum declared as instance field
	enum CoffeeType {
		CAPACHINO,
		LATTE
	}
	public CoffeeSize size;
	public CoffeeType type;
	public CoffeeContainer container;
	public CoffeeColor color;
	
	Coffee() {
	}
}
