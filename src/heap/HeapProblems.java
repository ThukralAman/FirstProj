package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

import javax.print.attribute.HashAttributeSet;

import com.sun.xml.internal.bind.marshaller.MinimumEscapeHandler;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class HeapProblems {
	
	// -------------- 1. https://www.geeksforgeeks.org/median-of-stream-of-running-integers-using-stl/----------
	// -- https://www.youtube.com/watch?v=VmogG01IjYc--------------------------------
	
	
	public void addNumberToPQ(Integer number, PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {
		if(lower.size() == 0 || number < lower.peek() ) {
			lower.add(number);
		}else {
			higher.add(number);
		}
		
	}
	
	public void reBalancePQ(PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {
		PriorityQueue<Integer> biggerPQ = lower.size() - higher.size() > 0 ? lower : higher;
		PriorityQueue<Integer> smallerPQ = lower.size() - higher.size() < 0 ? lower : higher;
		
		if(biggerPQ.size() - smallerPQ.size() >=2) {
			Integer polledInteger = biggerPQ.poll();
			smallerPQ.add(polledInteger);
		}
	}
	
	public Integer getMedian(PriorityQueue<Integer> lower, PriorityQueue<Integer> higher) {
		PriorityQueue<Integer> biggerPQ = lower.size() - higher.size() > 0 ? lower : higher;
		PriorityQueue<Integer> smallerPQ = lower.size() - higher.size() < 0 ? lower : higher;
		
		if(lower.size() == higher.size()) {
			return ( lower.peek() + higher.peek() ) / 2;
		}else {
			return biggerPQ.peek();
		}
	}
	
	
	public ArrayList<Integer> getMedians(ArrayList<Integer> num) {
		
		PriorityQueue<Integer> lower = new PriorityQueue(num.size(), new Comparator<Integer>() {
			@Override
			public int compare(Integer one, Integer two) {
				return -1 * (one-two);
			}
		});
	
		PriorityQueue<Integer> higher = new PriorityQueue<>();
		ArrayList<Integer> medians = new ArrayList<>();
		
		for(int i=0; i<num.size(); i++) {
			addNumberToPQ(num.get(i), lower, higher);
			reBalancePQ(lower, higher);
			Integer median = getMedian(lower, higher);
			medians.add(median);
		}
		
		return medians;
	}

	/*public static void main(String[] args) {
		HeapProblems obj = new HeapProblems();
		ArrayList<Integer> num = new ArrayList<Integer>(Arrays.asList(15, 5, 11, 43, 27, 66, 3));
		ArrayList<Integer> medians = obj.getMedians(num);
		System.out.println(medians);
	}*/

	
	// ---------- 1 END ----------------------------------- 	
	
	
	// ----------------2 https://www.geeksforgeeks.org/rearrange-characters-string-no-two-adjacent/ ----------
	
	public void addKeysToPQ(PriorityQueue<Key> pq, String str) {
		HashMap<Character, Integer> hm = new HashMap<>();
		for(int i=0; i<str.length(); i++) {
			if(hm.get(str.charAt(i)) == null) {
				hm.put(str.charAt(i), 1);
			}else {
				hm.put(str.charAt(i), hm.get(str.charAt(i)) + 1 );
			}
		}
		
		for(Character c : hm.keySet()) {
			Key k = new Key(c, hm.get(c));
			pq.add(k);
		}
	}
	
	public String getRearrangedNoDuplicateAdjacent(String str) {
		String res = "";
		PriorityQueue<Key> pq = new PriorityQueue<>(str.length(), new Comparator<Key>() {
			public int compare(Key k1, Key k2) {
				return -1 * (k1.freq - k2.freq);
			}
		});
		
		addKeysToPQ(pq, str);
		
		while(pq.size() >0) {
			Key k = pq.poll();
			res = res + k.c;
			k.freq--;
			if(k.freq!=0) {
				pq.add(k);
			}
		}
		
		return res;
	}
	
	
	/*public static void main(String[] args) {
		HeapProblems obj = new HeapProblems();
		String str = "aaabbbcc";
		String res = obj.getRearrangedNoDuplicateAdjacent(str);
		System.out.println(res);
	}*/
	
	public static class Key {
		Character c;
		int freq;
		
		Key(Character c, int freq) {
			this.c = c;
			this.freq = freq;
		}
	}
	
	// ---------------------- 2END ---------------------------------------
	
	// --------- 3: https://practice.geeksforgeeks.org/problems/kth-largest-element-in-a-stream/0 ------------------
	
	/*
	 *  The idea is to keep the array sorted so that the k’th largest element can be found in O(1) 
	 *  time (we just need to return first element of array if array is sorted in increasing order)
	 *	How to process a new element of stream?
	 *	For every new element in stream, check if the new element is smaller than current k’th largest element.
	 *	If yes, then ignore it. If no, then remove the smallest element from array and 
	 *	insert new element in sorted order. Time complexity of processing a new element is O(k).
	 */
	
	public ArrayList<Integer> getKthLargest(ArrayList<Integer> num, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(k);
		ArrayList<Integer> kthLargest = new ArrayList<>();
		
		for(int i=0; i<num.size(); i++) {
			
			if(pq.size() < k) {
				pq.add(num.get(i));
				kthLargest.add(0);
				continue;
			}
			
			/*
			 * Below code has been optimized  
			 * if(num.get(i) < pq.peek()) {
				kthLargest.add(pq.peek());
			}else {
				pq.poll();
				pq.add(num.get(i));
				kthLargest.add(pq.peek());
			}*/
			
			if(num.get(i) > pq.peek()) {
				pq.poll();
				pq.add(num.get(i));
			}
			kthLargest.add(pq.peek());
		}
		
		return kthLargest;
	}
	
	/*public static void main(String[] args) {
		HeapProblems obj = new HeapProblems();
		ArrayList<Integer> num = new ArrayList<Integer>(Arrays.asList(10, 20, 11, 70, 50, 40, 100, 5));
		ArrayList<Integer> kthLargest = obj.getKthLargest(num, 3);
		System.out.println(kthLargest);
	}*/
	
	// --------------- 3 END -------------------- 
	 // ------------ 4. https://www.geeksforgeeks.org/merge-k-sorted-arrays/ -------------------
	
	
	public static class MinHeapNode {
		int nodeValue;
		int listIndex;
		int nextIndexToPickInList;
		
		MinHeapNode(int nodeValue, int listIndex, int nextIndexToPickInList) {
			this.nodeValue = nodeValue;
			this.listIndex = listIndex;
			this.nextIndexToPickInList = nextIndexToPickInList;
		}
	}
	public void addFirstElementsOfEachList(PriorityQueue<MinHeapNode> pq, int[][] num) {
		for(int i=0; i<num.length; i++) {
			MinHeapNode mhn = new MinHeapNode(num[i][0], i, 1);
			pq.add(mhn);
		}
	}
	
	
	ArrayList<Integer> mergeSortedLists(int[][] num) {
		ArrayList<Integer> res = new ArrayList<>();
		PriorityQueue<MinHeapNode> pq = new PriorityQueue<>(num.length, new Comparator<MinHeapNode>() {
			public int compare(MinHeapNode n1, MinHeapNode n2)  {
				return n1.nodeValue - n2.nodeValue;
			}
		});
		
		// Add first element of each list to pq
		addFirstElementsOfEachList(pq, num);
		
		//Add heap top to result and add subsequent element from list to pq whose element has been added to result 
		// Do this while heap size is not zero
		while(pq.size() != 0) {
			MinHeapNode mhn = pq.poll();
			int listIndex = mhn.listIndex;
			int nextIndexToPickInList = mhn.nextIndexToPickInList +1;
			int nextValToAddInPQ;
			if(num[listIndex].length >= nextIndexToPickInList) {
				nextValToAddInPQ = num[mhn.listIndex][mhn.nextIndexToPickInList];
			}else {
				nextValToAddInPQ = Integer.MAX_VALUE;
			}
			
			if(nextValToAddInPQ != Integer.MAX_VALUE) {
				MinHeapNode newMHN =  new MinHeapNode(nextValToAddInPQ, listIndex, nextIndexToPickInList);
				pq.add(newMHN);
			}
			res.add(mhn.nodeValue);
		}
		
		return res;
	}
	
	
	public static void main(String[] args) {
		HeapProblems obj = new HeapProblems();
		int[][] num = { {2, 6, 12, 34},
				{1, 9, 20, 1000},
				{23, 34, 90, 2000}};
		ArrayList<Integer> res = obj.mergeSortedLists(num);
		System.out.println(res);
	}
	
	// ------------ 4: END -------------------------------------------------
	
}
