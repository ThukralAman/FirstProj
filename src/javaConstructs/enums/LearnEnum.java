package javaConstructs.enums;

/*
 * 
 *  1. NOTE: Yo cannot declare enum inside method.
 */

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
		
		
		for(CoffeeContainer container: CoffeeContainer.values()) {
			System.out.print(container + " ");
			System.out.println(container.getPrice());
		}
		
		d2.color = CoffeeColor.BLACK;
		System.out.println("d2 color LidCode= " + d2.color.getLidCode());
		
		

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
