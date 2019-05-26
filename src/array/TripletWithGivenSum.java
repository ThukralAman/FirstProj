package array;


import java.util.HashMap;
import java.util.Map;

public class TripletWithGivenSum {

    public void printTripletWithGivenSum(int[] arr, int sum) {
        for(int i=0; i<arr.length-2; i++) {
            Map<Integer, Integer> hm = new HashMap<>();
            int sumOfTwo = sum - arr[i];
            for(int j=i+1; j<arr.length; j++) {
                if(hm.get(sumOfTwo-arr[j]) !=null) {
                    System.out.println("Triplet found = " + arr[i] + ", " + arr[j] +  ", " + (sumOfTwo-arr[j]));
                    return;
                }else{
                    hm.put(arr[j], 1);
                }
            }
        }
        System.out.println("No triplet found!!");
    }

    public static void main(String[] args) {
        TripletWithGivenSum obj = new TripletWithGivenSum();
        int[] arr = { 1, 8, 45, 6, 10, 9 };
        int sum = 24;
        obj.printTripletWithGivenSum(arr, sum);

    }
}


