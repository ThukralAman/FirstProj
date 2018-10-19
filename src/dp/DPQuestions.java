package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.sun.xml.internal.bind.v2.util.EditDistance;

public class DPQuestions {
	
	//------------1. https://www.geeksforgeeks.org/ugly-numbers/ -----------------------------
	
	public int getNthUglyNo(int n) {
		/*
		 *  arr[0] = 1
		 *  i2, i3, i5 = 0
		 *  
		 *  
		 */
		
		int[] arr = new int[n];
		arr[0]=1;
		int i2 = 0;
		int i3 =  0;
		int i5 = 0;
		
		int next_ugly_2 = arr[i2] * 2;
		int next_ugly_3 = arr[i2] * 3;
		int next_ugly_5 = arr[i2] * 5;
		
		
		for(int i=1; i<n; i++) {
			  arr[i] = Math.min(next_ugly_2, Math.min(next_ugly_3, next_ugly_5));
			  if(arr[i] == next_ugly_2) {
				  i2++;
				  next_ugly_2 = arr[i2] * 2 ;
			  }
			  if(arr[i] == next_ugly_3) {
				  i3++;;
				  next_ugly_3 = arr[i3] * 3;
			  }
			  if(arr[i] == next_ugly_5) {
				  i5++;
				  next_ugly_5 = arr[i5] * 5;
			  }
		}
		
		return arr[n-1];
	}

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		DPQuestions obj = new DPQuestions();
		int n = 150;
        System.out.println(obj.getNthUglyNo(n));

	}*/
	
	
	// 2: --- Find combinations of valid parenthesis given n pair of parenthesis: -- n=2 => ()(), (()) --  sol:2 | n=3 sol:5
	public Set<String> getParenthesisCount(int n) {
		Set<String> parenthesisSet = new HashSet<>();
		if(n<1) {
			parenthesisSet.add("");
			return parenthesisSet;
		}
		
		parenthesisSet = getParenthesisCount(n-1);
		
		return null;
	}
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		DPQuestions obj = new DPQuestions();
		int n = 150;
        System.out.println(obj.getParenthesisCount(n));

	}*/
	
	// 3. ----------  LIS: https://www.geeksforgeeks.org/longest-increasing-subsequence/ -----------
	
	public int lis(int[] arr) {
		int max = -1;
		
		int[] lis = new int[arr.length];
		Arrays.fill(lis, 1);
		
		for(int i=1; i<arr.length; i++) {
			for(int j=0; j<i; j++) {
				if( (arr[i] > arr[j]) && (lis[j] + 1 > lis[i]) ) {
					lis[i] = lis[j] + 1;
					if(max < lis[i]) {
						max = lis[i];
					}
				}
			}
		}
		
		for(int i=0; i<lis.length; i++) {
			System.out.print(", " + lis[i]);
		}
		return lis[arr.length-1];
	}
	
	public int lis2(int[] arr) {
		int max = -1;
		
		int[] lis = new int[arr.length];
		Arrays.fill(lis, 1);
		
		// Iterate 
		for(int i=0; i<arr.length-1; i++)  {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[j] > arr[i] && lis[j] < lis[i] + 1) {
					lis[j]++;
					if(max < lis[j]) {
						max = lis[j];
					}
				}
			}
		}
		
		return max;
	}
	
	/*public int lisRecursive(int[] arr, int n, int[] dp) {
		if(n==0) {
			return 1;
		}
		
		for(int i=1; i<n; i++) {
			for(int j=0; j<i; j++) {
				dp[j] = lisRecursive(arr, j, dp);
				if(arr[i] > arr[j]) {
					dp[i] = 
				}
			}
		}
	}*/
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		DPQuestions obj = new DPQuestions();
		int[] arr1 = {10, 8, 9, 33, 21, 50, 41, 60, 80};
        System.out.println(obj.lis2(arr1));

	}*/
	
	// -------- 3 END --------------------------------
	
	int memoize[][];
	
	// ------------ 4 : https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/ -------------
	
	public int lcs(char[] X, char[] Y, int XEnd,int  YEnd) {
		
		
		
		if(XEnd == -1 || YEnd == -1) {
			return 0;
		}
		
		if(memoize[XEnd][YEnd] !=0) {
			return memoize[XEnd][YEnd];
		} 
		
		if(X[XEnd] == Y[YEnd]) {
			memoize[XEnd][YEnd] =  1 + lcs(X, Y, XEnd-1, YEnd-1);
		}else {
			memoize[XEnd][YEnd] = Math.max(lcs(X, Y, XEnd, YEnd-1), lcs(X, Y, XEnd-1, YEnd));
		}
		
		
		
		return memoize[XEnd][YEnd];
	}
	
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		DPQuestions obj = new DPQuestions();


		String s1 = "AGGTAB"; 
	    String s2 = "GXTXAYB"; 
	  
	    char[] X=s1.toCharArray(); 
	    char[] Y=s2.toCharArray(); 
	    int m = X.length; 
	    int n = Y.length;
	    obj.memoize = new int[m][n];
	    
	    System.out.println("LCS = " + obj.lcs(X, Y, m-1, n-1));

	}*/
	
	// ------- 4 END -----------------------------
	
	// ------ 5 https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/ ---------
	//----- https://www.youtube.com/watch?v=8LusJS5-AGo
	// --- https://www.youtube.com/watch?v=149WSzQ4E1g	
	
	
	// ImpNOTE: You can use hashmap to save space since value of w can be large and two d matrix will waste lot of space
	int[][] memoizeKS; 
	public int ks(int w, int[] val, int[] wt, int i) {
		
		if(w == 0 || i==val.length ) {
			return 0;
		}
		
		if(memoizeKS[w][i] !=0) {
			return memoizeKS[w][i];
		}
		
		if(wt[i] > w) {
			return ks(w, val, wt, i+1);
		}else {
			return Math.max(ks(w, val, wt, i+1), val[i] + ks(w-wt[i], val, wt, i+1));
		}
	}
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		DPQuestions obj = new DPQuestions();


		int[] wt = {10, 20, 30};
		int[] val = {60, 100, 120};
		int w = 50;
		
		obj.memoizeKS  = new int[w+1][wt.length];
	    
	    System.out.println("Max weight = " + obj.ks(w, val, wt, 0));

	}*/
	
	
	// ------------ 5 END -----------------------------------------------------
	
	// 6 - https://www.geeksforgeeks.org/edit-distance-dp-5/ ----------------------------
	// -------- https://www.youtube.com/watch?v=XJ6e4BQYJ24&list=PLMCXHnjXnTnto1pZVvH7rbZ9W5neZ7Yhc&index=12 --------
	
	public int min(int x, int y, int z) {
		return Math.min(x, Math.min(y, z));
	}
	
	public int editDistance(String s1, String s2, int m, int n) {
		
		if(n == 0) {
			return m;
		}else if(m == 0)  {
			return n;
		}
		
		if(s1.charAt(m-1) == s2.charAt(n-1)) {
			return editDistance(s1, s2, m-1, n-1);
		}
		else{
			// - insert character in s1  => editDistance(s1, s2, m, n-1)  
			// NOTE Adding character for I (s1=sun, s2=satur, 2, 4)  will => II (s1=sunr, s2=satur, 3, 4)  AND this eventually will lead back to 
			// III(s1=sun, s2=satu, 2, 3)    So we can effectively transform I directly o III 
			
			// update character  => editDistance(s1, s2, m-1, n-1)
			
			// Delete character  => editDistance(s1, s2, m-1, n)
			
			
			return 1 +  min( editDistance(s1, s2, m, n-1), 
				 editDistance(s1, s2, m-1, n-1),
				 editDistance(s1, s2, m-1, n)
				);
			
		}	
	}
	
	
	public int editDistanceMemoized(String s1, String s2, int m, int n) {
		if(m==0) {
			return n;
		}else if(n==0) {
			return m;
		}
		
		if(s1.charAt(m-1) == s2.charAt(n-1)) {
			if(editDistance[m-1][n-1] != -1) {
				return editDistance[m-1][n-1];
			}else {
				return editDistance(s1, s2, m-1, n-1);
			}
		}else {
			int insertDistance;
			int updateDistance;
			int deleteDistance;
			if(editDistance[m][n-1] != -1) {
				insertDistance = editDistance[m][n-1];
			}else {
				insertDistance = editDistance(s1, s2, m, n-1);
			}
			
			if(editDistance[m-1][n-1] !=-1) {
				updateDistance = editDistance[m-1][n-1];
			}else {
				updateDistance = editDistance(s1, s2, m-1, n-1);
			}
			
			if(editDistance[m-1][n] != -1) {
				deleteDistance = editDistance[m-1][n];
			}else {
				deleteDistance = editDistance(s1, s2, m-1, n);
			}
			
			return 1 + min(insertDistance, updateDistance, deleteDistance);
		}
		
		
	}
	
	public int[][] editDistance;
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		DPQuestions obj = new DPQuestions();


		String s1 = "Sunday";
		String s2 = "Saturday";
		
		
		obj.editDistance = new int[s1.length()][s2.length()];
		
		for(int i=0; i<s1.length(); i++) {
			Arrays.fill(obj.editDistance[i], -1);
		}
		
	    
	    System.out.println("Edit Distance = " + obj.editDistance( s1, s2, s1.length(), s2.length() ) );
		System.out.println("Edit Distance = " + obj.editDistanceMemoized( s1, s2, s1.length(), s2.length() ) );

	}*/

	// --------------------- 6 END ---------------------------------------------------
	
	// 7 - https://www.geeksforgeeks.org/coin-change-dp-7/
	
	
	/* Problem With this solution: 
	 *  Actual solution: {1,1,1,1}, {1,1,2}, {2,2}, {1,3}
	 *  
	 *  But this solution gives result as 7 because it will consider {1,1,2} and {2,1,1} as separate solutions,
	 *  hence it gives more number of ways
	 */
	
	// Approach in this solution: Take 0th coin and compute remaining + take 1th coin and compute remaining + take 2th coin and compute remailing
	
	
	/*public int coinChange(int[] arr, int n) {
		int total=0;
		
		if(n==0) {
			return 1;
		}else if(n<0) {
			return 0;
		}
		
		for(int i=0; i<arr.length; i++) {
			total += coinChange(arr, n-arr[i]);
		}
		return total;
	}*/
	
	
	/*
	 * Correct solution
	 */
	
	Map<Integer, Map<Integer, Integer>> hm = new HashMap<>();
	
	public int coinChange(int[] arr, int m, int n) {
		
		if(n==0) {
			return 1;
		}
		
		if(n < 0) {
			return 0;
		}
		
		if( m<=0) {
			return 0;
		}
		
		if(hm.get(m) == null || hm.get(m).get(n) == null) {
			int output =  coinChange(arr, m-1, n) + coinChange(arr, m, n-arr[m-1]);
			Map<Integer, Integer> tempHM = hm.get(m);
			if(tempHM == null) {
				tempHM = new HashMap<>();
			}
			tempHM.put(n, output);
			hm.put(m, tempHM);
			return output;
		}else {
			return hm.get(m).get(n);
		}
		
		
	}

	// Method 2 given on GFG and youtube link is : https://www.youtube.com/watch?v=jaNZ83Q3QGc
	public int countWays(int S[], int m, int n)
	{
		//Time complexity of this function: O(mn)
		//Space Complexity of this function: O(n)

		// table[i] will be storing the number of solutions
		// for value i. We need n+1 rows as the table is
		// constructed in bottom up manner using the base
		// case (n = 0)
		int[] table = new int[n+1];

		// Initialize all table values as 0
		Arrays.fill(table, 0);   //O(n)

		// Base case (If given value is 0)
		table[0] = 1;

		// Pick all coins one by one and update the table[]
		// values after the index greater than or equal to
		// the value of the picked coin

		// - Logic: In the table [0, 1, 2, 3, 4] represents the final amount to achievw
		// - S[] = {1, 2, 3} represent coins
		// - Now table[0] = 1 since there is only one way to create amount 0 from coins 1, 2, 3 which is choose no coin
		// - Now we start for coin '1' in j loop and loop from j = 1-4(4 is the amount for which ways to calculate)
		// - Now for table[1] represents number of ways to reach amount 1 using coins and since we have '1' coin, if we choose 1,
		// 	 then we have to make amount 0. And number of ways to make amount 0, as already discussed is 1, so number
		//   of ways to make amount 1 with '1' coin is table[1] = table[1-1]
		// - Now looping for j=2, we have to calculate ways for table[2] with '1' coin. Now if we choose one '1' coin, then
		//   we have to find ways of reaching remaining amount (2-1) =1 which we already calculated previously.
		//	 So with coin '1' table[2] = table[2-1] = 1
		// - Now we loop like this for j-1-4 and each entry of table[1..4] is calculated to be 1
		// - Now comes the turn of second coin '2'. If coin '2' is to be used then min amount should be >=2
		// - So we loop for amount from j = 2-4
		// - Now for j=2 which signifies amount for which number of ways has to be calculted, if we choose coin '2', then
		//   remaining amount left is 0, So number of ways to calculate amount = 2 with '2' coin = table[2] = table[2-2]
		// Now to calculate for amount = 3 (j=3), if we select coin '2', then we have to find number of ways to calculate
		// for amount 3-2, which is already present at table[1]

		/*
			- Generalising, for a given coin,
				if (amount>=coin), then
				numOfWays[amount] = numOfWays[amount] + numOfWays[amount-coin]
		 */
		for (int i=0; i<m; i++)
			for (int j=S[i]; j<=n; j++)
				table[j] += table[j-S[i]];

		return table[n];
	}


	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		DPQuestions obj = new DPQuestions();
		
		
		
		int n=10000;
		int[] arr = {1,2,3};
		int result = obj.coinChange(arr, arr.length, n);
		*//*int result = obj.countWays(arr, arr.length, n);*//*
		System.out.println("Coin change Ways: " + result);

		//System.out.println("Edit Distance = " + obj.editDistanceMemoized( s1, s2, s1.length(), s2.length() ) );

	}*/

	// -------------- 7 END : -----------------------------

	// ----- 8: https://www.geeksforgeeks.org/subset-sum-problem-dp-25/ ----------------------
	// https://www.youtube.com/watch?v=s6FhG--P7z0

	public boolean  subsetSum(int[] arr, int m, int sum) {

		if(sum==0) {
			return true;
		}
		if(sum < 0 || m <=0) {
			System.out.println("m = " + m + "rejected");
			return false;
		}

		return (subsetSum(arr, m-1, sum) || subsetSum(arr, m-1, sum-arr[m-1]));
	}

	public boolean subsetSumTabulized(int[] arr, int m, int sum) {

		boolean[][] subset = new boolean[m+1][sum+1];

		// if sum ==0 then all subsets are true
		for(int i=0; i<subset.length; i++) {
			subset[i][0] = true;
		}

		// if set is empty, then no subset to form
		for(int i=1; i<subset[0].length; i++) {
			subset[0][i] = false;
		}

		for(int i=1; i<=m; i++) {
			for(int j=1; j<=sum; j++) {
				subset[i][j] = subset[i-1][j];
				if( j >= arr[i-1] ) {
					subset[i][j] = subset[i][j] || subset[i-1][j-arr[i-1]];
				}
			}
		}
		return subset[m][sum];
	}

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		DPQuestions obj = new DPQuestions();



		int sum=27;
		int[] arr = {3,34,4,6,6,5,2};
		*//*boolean result = obj.subsetSum(arr, arr.length, sum);*//*
		boolean result = obj.subsetSumTabulized(arr, arr.length, sum);
		System.out.println("Coin change Ways: " + result);

		//System.out.println("Edit Distance = " + obj.editDistanceMemoized( s1, s2, s1.length(), s2.length() ) );

	}*/

	// ------------ 8 END -------------------------------

	// --------- 9 : https://www.geeksforgeeks.org/box-stacking-problem-dp-22/ ----------
	// https://www.youtube.com/watch?v=KgWy0fY0dRM
	//https://www.youtube.com/watch?v=9mod_xRB-O0

	/*
			Steps:
				1) There are 3 possible rotations of a box
					- Use original height as height -> LxBxH = l x b x h
					- Use original length as height -> LxBxH = h x b x l
					- Use original width as height  -> LxBxH = h x l x b

					eg (1,2,3) -> (3,2,1), (3,1,2)
				NOTE: Here we are not considering rotations on length-width so, (1,2,3) and (2,1,3) are same here
				So, given n boxes arr[n], create arrAllCombinations[n*3]

				 2) Sort the arrAllCombinations by their base area i.e lxb.

				 3) Initialise lis[0...n*3] as box[i].h . this is because if only one box is choosen, then max height will be box[i].h
				 4) Apply LIS.
				 	for(int i=1; i<n*3; i++) {
				 		for(j=0; j<i; j++) {
				 			if(box[i] can be stacked over box[j]) {// l,b of box 'i' are lesser than l,b of boxj
				 				lis[i] = lis[i] + lis[j]
				 			}

				 		}
				 		if(lis[i] > max) {
				 			update max = lis[i]
				 		}

				 	}

				 5) return max
	 */

	// --------------- 9 END ------------------------

	// 10: https://www.geeksforgeeks.org/cutting-a-rod-dp-13/


	// memoize this by saving result[i]
	int[] memoizeRodCut;
	public long rodCutting(int[] arr, int m) {

		if(m==0 ) {
			return 0;
		}

		long result;
		long max = -1;
		for(int i=0; i<m; i++) {
			if(memoizeRodCut[m-1-i] != -1) {
				result = memoizeRodCut[m-1-i];
			}else {
				result = arr[i] + rodCutting(arr, m-1-i);
			}

			max = Math.max(max, result );
		}

		return max;
	}

	public long tabulizedRodCut(int[] arr, int m) {

		// val[i] denotes the max value obtained by cutting rod of lenghth i
		int[] val = new int[m+1];
		val[0] = 0;

		for(int i=1; i<=m; i++) {
			for(int j=0; j<i; j++) {

			}
		}

		return 0;
	}


	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		DPQuestions obj = new DPQuestions();



		int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
		obj.memoizeRodCut = new int[arr.length];
		Arrays.fill(obj.memoizeRodCut, -1);

				*//*boolean result = obj.subsetSum(arr, arr.length, sum);*//*
		long result = obj.rodCutting(arr, arr.length);
		System.out.println("Max rod cutting: " + result);

		//System.out.println("Edit Distance = " + obj.editDistanceMemoized( s1, s2, s1.length(), s2.length() ) );

	}*/

	// ----------------------- 10 END -------------------

	// 11: https://www.geeksforgeeks.org/find-the-longest-path-in-a-matrix-with-given-constraints/
	

	public int longestincreasingPathInMatrixUtil(int[][] arr, int[][] dp, int i, int j) {
		int n = arr.length;
		if(i<0 || i>n-1 || j<0 || j>n-1) {
			return 0;
		}

		if(dp[i][j] != -1) {
			return dp[i][j];
		}

		if(j<n-1 && (arr[i][j] +1) == arr[i][j+1]) {
			return 1 + longestincreasingPathInMatrixUtil(arr, dp, i, j+1);
		}
		if(j>0 && (arr[i][j] + 1) == arr[i][j-1]) {
			return 1 + longestincreasingPathInMatrixUtil(arr, dp, i, j-1);
		}
		if(i<n-1 && (arr[i][j] + 1) == arr[i+1][j]) {
			return 1 + longestincreasingPathInMatrixUtil(arr, dp, i+1, j);
		}
		if(i>0 && (arr[i][j] + 1) == arr[i-1][j]) {
			return 1 + longestincreasingPathInMatrixUtil(arr, dp, i-1, j);
		}

		dp[i][j] = 1;
		return dp[i][j];
	}

	public int longestincreasingPathInMatrix(int[][] arr) {
		int n = arr.length;
		int dp[][] = new int[n][n];
		int max = -1;

		for(int i=0; i<n; i++) {
			Arrays.fill(dp[i], -1);
		}

		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(dp[i][j] == -1) {
					dp[i][j] = longestincreasingPathInMatrixUtil(arr, dp, i, j);
					max = Math.max(max, dp[i][j]);
				}
			}
		}

		return max;
	}


	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		DPQuestions obj = new DPQuestions();




		int  arr[][] = { {1, 2, 9},
				{5, 3, 8},
				{4, 6, 7} };



		*//*boolean result = obj.subsetSum(arr, arr.length, sum);*//*
		long result = obj.longestincreasingPathInMatrix(arr);
		System.out.println("LongestIncreasing path in matrix differing by just 1 = : " + result);

		//System.out.println("Edit Distance = " + obj.editDistanceMemoized( s1, s2, s1.length(), s2.length() ) );

	}*/

	// --- 11 END -------------------

	//  ----- 12: https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/



	public int partitionSubsetMinDiff(int[] arr, int m, int sumLeft, int sumRight) {

		if(m==0) {
			return Math.abs(sumLeft-sumRight);
		}

		if(memoizePartitionSum[m-1] !=-1) {
			return memoizePartitionSum[m-1];
		}
		int accepted = partitionSubsetMinDiff(arr, m-1, sumLeft-arr[m-1], sumRight+arr[m-1]);
		int rejected = partitionSubsetMinDiff(arr, m-1, sumLeft, sumRight);

		memoizePartitionSum[m-1] = Math.min(accepted, rejected);
		return Math.min(accepted, rejected);
	}

	int[] memoizePartitionSum;

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		DPQuestions obj = new DPQuestions();

		//int arr[] = {3, 1, 4, 2, 2, 1};

		int arr[] = {10, 6, 18, 5};
		obj.memoizePartitionSum = new int[arr.length];
		Arrays.fill(obj.memoizePartitionSum, -1);

		int sum=0;
		for(int i=0; i<arr.length; i++) {
			sum = sum + arr[i];
		}


		*//*boolean result = obj.subsetSum(arr, arr.length, sum);*//*
		long result = obj.partitionSubsetMinDiff(arr, arr.length, sum, 0);
		System.out.println("Min difference after partitioning = : " + result);

		//System.out.println("Edit Distance = " + obj.editDistanceMemoized( s1, s2, s1.length(), s2.length() ) );

	}*/

	// ------------------------------------- 12 END  -----------------

	// ---- 13; https://www.geeksforgeeks.org/egg-dropping-puzzle-dp-11/

	/*
		Problem Description:
		Preconditions:
			> If egg breaks at a particular floor it breaks for all he floors above it
			> If the egg survives breakage at particular floor, then it will not break for any floors lower than that floor

		Given n eggs and k floors, you have to find
			- minimum number of egg drops using n eggs to find the critical floor
				* Critical floor is defined as the floor at which if egg is thrown, then it breaks
				* If egg is thrown from any floor below the critical floor, egg will not break
				* If egg is thrown from any floor above the critical floor, then egg breaks
			- Consider the possibility of first egg being thrown starting from each floor from 1-k. And critical floor being found with worst
			  case for each floor
			- For each floor, from which egg is thrown for the first time. there are two possibilities. Assume there are 5 floors and
			  you start throwing first egg from floor 2
				+ Egg breaks. In this case we need to look for critical floor in k-1 floors.
					If egg breaks at floor 2, then my problem statement reduces to (1 egg) and 1 floor
				+ Egg does not break. in this case critical floor will be any floor above floor 2.
					So my problem reduces to finding critical floor with (2 eggs) and (3 floors)

				Now out of these 2 possibilities that arise from dropping egg at floor2, we have to chose the possibility
				DP(1,1) OR DP(2, 3)
				We choose the possibility which takes us towards worst case of finding the critical floor bcoz thats what question demands
				So for finding the critical floor in worst case, if egg is dropped from floor2, we calculate
				max( DP(1,1), DP(2, 3) ).


				So for (2egg, 5 floor) we find trials of finding critical floor by starting from different floors from 1-5
				And when finding the critical floor when starting from each of these floors, we take the worst case scenario of finding critical floor
				And once we find values for finding critical floor, for each floor by starting to throw the first egg from that floor
				We return the min f those values

				For eg for (2eggs, 5 floors)

				If we started from first floor, then no. of trials for finding critical floor in worst case = 1 + max( DP(1, 0), DP(2, 4) ) = 4(fake value just for example)
				NOTE: We added 1 because we dropped egg from first floor which is one trial in itself

				if we started from second floor,  then no. of trials for finding critical floor in worst case = 1 + max( DP(1, 2), DP(2, 3) ) = 3(fake value)

				if we started from third floor,  then no. of trials for finding critical floor in worst case = 1 + max( DP(1, 2), DP(2, 2) ) = 6(fake value)

				if we started from fourth floor,  then no. of trials for finding critical floor in worst case = 1 + max( DP(1, 3), DP(2, 1) ) = 3(fake value)

				if we started from fifth floor,  then no. of trials for finding critical floor in worst case = 1 + max( DP(1, 4), DP(2, 0) ) = 4(fake value)
				  to finding

				So for (2eggs, 5floors) minimum trials required in worst cases is 3 which happens if we start throwing eggs from fourth floor or second floor



			SEE CODE: https://www.geeksforgeeks.org/egg-dropping-puzzle-dp-11/
	 */

	// --------------- 13 END ------------------

	//  -------- 14. https://www.geeksforgeeks.org/optimal-strategy-for-a-game-dp-31/ ----------------


	/*
	Problem statement: Consider a row of n coins of values v1 . . . vn, where n is even. We play a game against an opponent
	 by alternating turns. In each turn, a player selects either the first or last coin from the row, removes it from the row
	  permanently, and receives the value of the coin. Determine the maximum possible amount of money we can definitely win
	  if we move first.

	Note: The opponent is as clever as the user.
	 */

	public int optimalGainFromGame(int[] arr, int start, int end) {

		/*if(start == end) {
			return arr[end];
		}*/

		if(end-start ==2) {
			return Math.max(arr[start], arr[end-1]);
		}

		if(memoizeGameMax[start][end-1] != -1) {
			return memoizeGameMax[start][end];
		}

		int result = Math.max(
								arr[start] + Math.min(
													optimalGainFromGame(arr, start+2, end),
													optimalGainFromGame(arr, start+1, end-1 )
													),
							  	arr[end-1] + Math.min(
							  						optimalGainFromGame(arr, start+1, end-1),
									  				optimalGainFromGame(arr, start, end-2)
							  						)
								);
		return result;
	}


	int[][] memoizeGameMax;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DPQuestions obj = new DPQuestions();

		int arr[] = { 20, 30, 2, 2, 2, 10 };
		obj.memoizeGameMax = new int[arr.length][arr.length];
		for(int i=0; i<arr.length; i++) {

			Arrays.fill(obj.memoizeGameMax[i], -1);
		}


		//int arr[] = {3, 1, 4, 2, 2, 1};

		/*int arr[] = { 8, 15, 3, 7 };*/

		//int arr[] = { 20, 30, 2, 2, 2, 10 };
		int result = obj.optimalGainFromGame(arr, 0, arr.length);
		System.out.println("max amount collected: " + result);



	}


	// ------ 14 END ----------------------------

	// ------------ 15: https://www.geeksforgeeks.org/shortest-common-supersequence/ -------------

	/*
	Given two strings str1 and str2, find the shortest string that has both str1 and str2 as subsequences.
	Examples :

	Input:   str1 = "geek",  str2 = "eke"
	Output: "geeke"

	Input:   str1 = "AGGTAB",  str2 = "GXTXAYB"
	Output:  "AGXGTXAYB"
	 */

	/*
			Solution:
			We need to find a string that has both strings as subsequences and is shortest such string. If both strings have
			all characters different, then result is sum of lengths of two given strings. If there are common characters,
			then we don’t want them multiple times as the task is to minimize length. Therefore, we fist find the longest
			common subsequence, take one occurrence of this subsequence and add extra characters.


			Length of the shortest supersequence  = (Sum of lengths of given two strings) -
                                        (Length of LCS of two given strings)
	 */

	

}
