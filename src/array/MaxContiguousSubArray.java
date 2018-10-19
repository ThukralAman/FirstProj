package array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxContiguousSubArray {
	
	public static void main(String args[]) {
		MaxContiguousSubArray obj = new MaxContiguousSubArray();
		List<Integer> list1 = new ArrayList<Integer>();
		//list1.addAll(Arrays.asList(1, 1, -3, 4, 5));
		list1.addAll(Arrays.asList(2,1,-5,2,-1,3,1,-5,4));
		int res = obj.maxSubArray(list1);
		System.out.println("res = " + res);
	}
	
	
	public int maxSubArray(final List<Integer> a) {
	    int currSum = 0,
	    maxSum = Integer.MIN_VALUE,
	    flag_all_negative = 1,
	    currSumStart=0,
	    currSumEnd=0,
	    maxSumStart=0,
	    maxSumEnd=0;
	    //startIndex = 0, endIndex = 0;
	    
	    for(int i=0; i<a.size(); i++) {
	        if(a.get(i) >=0) {
	            flag_all_negative = 0;
	            break;
	        }
	        else if(maxSum < a.get(i)) {
	            maxSum = a.get(i);
	            maxSumStart=i;
	            maxSumEnd=i;
	        }
	    }
	    
	    if(flag_all_negative == 1) {
	    	System.out.println("startIndex = " + maxSumStart + " and endIndex =  " + maxSumEnd);
	        return maxSum;
	    }
	    
	    for(int i=0; i<a.size(); i++) {
	        currSum += a.get(i);
	        currSumEnd = i;
	        if(currSum < 0) {
	            currSum = 0;
	            currSumStart=i+1;
	            currSumEnd=i+1;
	        }
	        
	        if(maxSum < currSum) {
	            maxSum = currSum;
	            maxSumStart = currSumStart;
	            maxSumEnd = currSumEnd;
	        }
	        
	    }
	    System.out.println("startIndex = " + maxSumStart + " and endIndex =  " + maxSumEnd);
	    return maxSum;
	    
	    
	}

}
