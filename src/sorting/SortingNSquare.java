package sorting;


public class SortingNSquare {
	
	void swap(int num[], int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
	
	void insertionSort(int num[]) {
		for(int i=1; i<num.length; i++) {
			int temp = num[i],
				j=i-1;
			while(  j>=0 && num[j] > temp) {
				num[j+1] = num[j];
				j--;
			}
			num[j+1] = temp;
		}
	}
	
	void selectionSort(int num[]) {
		for(int i=0; i<num.length-1; i++ ) {
			for(int j=i+1; j<num.length; j++) {
				if(num[i] < num[j]) {
					swap(num, i, j);
				}
			}
		}
	}
	
	void bubbleSort(int num[]) {
		for(int i=0; i<num.length; i++) {
			for(int j=0; j< (num.length-1)-i; j++) {
				if(num[j] > num[j+1]) {
					swap(num, j, j+1);
				}
			}
		}
	}
	
	public static void main(String args[]) {
		SortingNSquare sort = new  SortingNSquare();
		int num[] = new int[10];
		GetInput input = new GetInput(10);
		//num = input.getInputArray(10);
		num = input.getFilledRandomArray();
		//sort.selectionSort(num);
		//sort.bubbleSort(num);
		sort.insertionSort(num);
		input.printArray("Your sorted array is ");
	}
}
