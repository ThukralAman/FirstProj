package sorting;

import java.util.Scanner;

public class GetInput {
	int num[],
	count;
	
	GetInput(int count) {
		//num = new int[count];
		this.count = count;
	}
	
	public int[] getInputArray(int count){
		num = new int[count];
		Scanner sc = new Scanner(System.in); 
		for(int i=0; i<count; i++) {
			num[i] = sc.nextInt();
		}
		sc.close();
		return num;
	}
	
	public int[] getFilledRandomArray() {
		int numArray[] = {33, 2, 198, 89, 1004, 65, 56789, 7, 43, 765 };
		System.out.println("Input array is :");
		for(int i=0; i<numArray.length; i++) {
			System.out.print(numArray[i] + ", ");
		}
		num = numArray;
		return(numArray);
		
	}
	
	public int[] getFilledOrderedArray() {
		num = new int[count];
		for(int i=0; i<count; i++) {
			num[i] = i;
		}
		return num;
	}
	
	public void printArray(Object... msg) {
		String message = "";
		if(msg.length > 0){
			message = (String)msg[0];
		}
		System.out.println(message);
		for(int i=0; i<count; i++) {
			System.out.println(num[i]);
		}
	}

}
