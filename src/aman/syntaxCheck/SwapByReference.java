package aman.syntaxCheck;

class Ints {
	int data=0;
}

public class SwapByReference {
	
	public void swap(Integer a, Integer b) {
		int temp = a;
		a=b;
		b=temp;
	}
	
	public void swap(Ints a, Ints b) {
		int temp = a.data;
		a.data=b.data;
		b.data=temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SwapByReference obj = new SwapByReference();
		
		
		
		/*Integer x = 10;
		Integer y = 20;
		obj.swap(x, y);
		System.out.println("x = " + x + " y: " + y);*/

		Ints x = new Ints() ;
		Ints y = new Ints();
		x.data = 10;
		y.data = 20;
		
		obj.swap(x, y);
		System.out.println("x = " + x.data + " y: " + y.data);
		
	}

}
