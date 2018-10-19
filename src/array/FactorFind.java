package array;

import java.util.ArrayList;

import javax.swing.SingleSelectionModel;

public class FactorFind {
	public static void main(String args[]) {
		//System.out.println("Hello");
		//new FactorFind().allFactors(85463);
		new FactorFind().primesum(28);
	}
	
	public ArrayList<Integer> allFactors(int a) {
		//System.out.println("Hello11");
	     ArrayList<Integer> list=new ArrayList<Integer>();
	     ArrayList<Integer> list1=new ArrayList<Integer>();
	     ArrayList<Integer> list2=new ArrayList<Integer>();//Creating arraylist  
	     for(int i=1; i<Math.sqrt(a); i++){
	    	 //System.out.println("Hello112");
	         if(a%i == 0){
	             list1.add(i);
	             System.out.println(i);
	             if(i != Math.sqrt(a)){
	                 list2.add(a/i);
	                 System.out.println(a/i);
	             }
	         }
	     }
	     
	     System.out.println("size = " + list.size()); 
	     for(int i=list1.size()-1; i>=0; i--) {
	    	 System.out.println(list1.get(i));
	     }
	     
	     /*for(Integer x: list2) {
	    	 System.out.println(x);
	     }*/
	     return (list);
	}
	
	/*public ArrayList<Integer> primesum(int a) {
		ArrayList<Integer> primeList_pair = new ArrayList<Integer>();
        ArrayList<Integer> primeList = new ArrayList<Integer>();
        primeList = getPrimeList(a);
        for(int i=0; i<primeList.size(); i++) {
        	System.out.println(primeList.get(i));
        }
        
        int start = 0,
        end = primeList.size()-1;
        System.out.println(start);
        System.out.println(end);
        
        while(start<=end) {
            int sum = primeList.get(start) + primeList.get(end);
            if(sum < a) {
                start++;
            }
            else if(sum>a){
                end--;
            }
            else{
            	primeList_pair.add(primeList.get(start));
            	primeList_pair.add(primeList.get(end));
            	System.out.println(primeList.get(start));
            	System.out.println(primeList.get(end));
            	return primeList_pair;
            }
        }
        return primeList_pair;
        
    }
    
    public ArrayList<Integer> getPrimeList(int a) {
        ArrayList<Integer> primeList = new ArrayList<Integer>();
        ArrayList<Integer> primeList_final = new ArrayList<Integer>();
        for(int i=0; i<=a; i++) {
            primeList.add(1);
        }
        
        primeList.set(0,0);
        primeList.set(1,0);
        
        for(int i=2; i<=Math.sqrt(a); i++) {
            for(int j=2; j*i <= a; j++) {
                primeList.set(j*i, 0);
            }
        }
        
        for(int i=0; i<=a; i++) {
            if(primeList.get(i) !=0) {
                primeList_final.add(i);
            }
        }
        
        return(primeList_final);
    }*/
	
	/*public ArrayList<Integer> primesum(int a) {
		ArrayList<Integer> primeList_pair = new ArrayList<Integer>();
        ArrayList<Integer> primeList = new ArrayList<Integer>();
        primeList = getPrimeList(a);
        for(int i=0; i<primeList.size(); i++) {
        	System.out.println(primeList.get(i));
        }
        
        int start = 0,
        end = primeList.size()-1;
        System.out.println(start);
        System.out.println(end);
        
        while(start<=end) {
            int sum = primeList.get(start) + primeList.get(end);
            if(sum < a) {
                start++;
            }
            else if(sum>a){
                end--;
            }
            else{
            	primeList_pair.add(primeList.get(start));
            	primeList_pair.add(primeList.get(end));
            	System.out.println(primeList.get(start));
            	System.out.println(primeList.get(end));
            	return primeList_pair;
            }
        }
        return primeList_pair;
        
    }
    
    public ArrayList<Integer> getPrimeList(int a) {
        ArrayList<Integer> primeList = new ArrayList<Integer>();
        ArrayList<Integer> primeList_final = new ArrayList<Integer>();
        for(int i=0; i<=a; i++) {
            primeList.add(1);
        }
        
        primeList.set(0,0);
        primeList.set(1,0);
        
        for(int i=2; i<=Math.sqrt(a); i++) {
            for(int j=2; j*i <= a; j++) {
                primeList.set(j*i, 0);
            }
        }
        
        for(int i=0; i<=a; i++) {
            if(primeList.get(i) !=0) {
                primeList_final.add(i);
            }
        }
        
        return(primeList_final);
    }*/
	
	public boolean isPrime(int a) {
		
		for(int i=2; i<=Math.sqrt(a); i++ ) {
			if(a%i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public ArrayList<Integer> primesum(int a) {
		ArrayList<Integer> primeList_pair = new ArrayList<Integer>();
        ArrayList<Integer> primeList = new ArrayList<Integer>();
        int start =2,
        		end = a-2;
        
        while(start <=a/2 ) {
        	boolean isStartPrime = isPrime(start),
        			isEndPrime = isPrime(end);
        	if(isStartPrime && isEndPrime) {
        		primeList_pair.add(start);
        		primeList_pair.add(end);
        		System.out.println(start);
        		System.out.println(end);
        		return primeList_pair;
        	}
        	else{
        		start++;
        		end--;
        	}
        }
        
        return primeList_pair;
        
        /*primeList = getPrimeList(a);
        for(int i=0; i<primeList.size(); i++) {
        	System.out.println(primeList.get(i));
        }
        
        int start = 0,
        end = primeList.size()-1;
        System.out.println(start);
        System.out.println(end);
        
        while(start<=end) {
            int sum = primeList.get(start) + primeList.get(end);
            if(sum < a) {
                start++;
            }
            else if(sum>a){
                end--;
            }
            else{
            	primeList_pair.add(primeList.get(start));
            	primeList_pair.add(primeList.get(end));
            	System.out.println(primeList.get(start));
            	System.out.println(primeList.get(end));
            	return primeList_pair;
            }
        }
        return primeList_pair;*/
        
    }
	
}
