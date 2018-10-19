package sorting;


public class SortingNLogn {
	
	/* Merge Sort Algo START*/
	
	void mergeSort(int num[], int l, int h) {
		if( l<h ) {  // NOTE: Here l<=h makes way for infinite loop
			int m = (l+h)/2;
			mergeSort(num, l, m);
			mergeSort(num, m+1, h);
			merge(num, l, m, h);
		}
	}
	
	void merge(int num[], int l, int m, int h) {
		int temp[] = new int[num.length];
		int j=l,
			k=m+1,
			p = j;
		/*System.out.println("Before- ");
		for(int i=j; i<=h; i++) {
			System.out.println(num[i]);
		}*/
		
		while(j<=m && k<=h) {
			if(num[j] < num[k]) {
				temp[p] = num[j];
				j++;
			}
			else {
				temp[p] = num[k];
				k++;
			}
			p++;
		}
		
		if(j<=m) {
			for(int q=j; q<=m ; q++) {
				temp[p] = num[q];
				p++;
			}
		}
		else{
			for(int q=k; q<=h ; q++) {
				temp[p] = num[q];
				p++;
			}
		}
		
		for(int i=l; i<=h; i++) {  //NOTE: here initializing i=j will not take i to start index as j has been modified earlier.
			num[i] = temp[i];
		}
		
		/*System.out.println("After- ");
		for(int i=l; i<=h; i++) {
			System.out.println(num[i]);
		}*/
	}
	
	/* Merge Sort Algo END */
	
	/* Quick Sort Algo Start */
	void quickSort(int num[], int l, int h) {
		if(l<h) {
			int p = partition(num, l, h);
			quickSort(num, l, p-1);
			quickSort(num, p+1, h);
		}
	}
	
	
	int partition(int num[], int l, int h) {
		Utils utils = new Utils();
		int pivot = num[h];
		int pIndex = l;
		
		for(int i=l; i<h; i++) {
			if(num[i] < pivot) {
				utils.swap(num, pIndex, i);
				pIndex++;
			}
		}
		
		utils.swap(num, h, pIndex);
		return pIndex;
	}
	/* QuickSortAlgo END */
	
	public static void main(String args[]) {
		SortingNLogn sort = new  SortingNLogn();
		int num[] = new int[10];
		//int num[] = {7,6,5,4,3,2,1};
		GetInput input = new GetInput(10);
		//num = input.getInputArray(10);
		num = input.getFilledRandomArray();
		//sort.mergeSort(num, 0, num.length-1);
		sort.quickSort(num, 0, num.length-1);
		for(int i=0; i<num.length; i++) {
			System.out.println(num[i] + ", ");
		}
		//input.printArray("Your sorted array is ");
	}
}
