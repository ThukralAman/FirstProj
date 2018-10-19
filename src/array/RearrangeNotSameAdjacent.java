package array;
// chandan gave this code on hangout
//https://www.geeksforgeeks.org/rearrange-characters-string-no-two-adjacent/
// This solution fails at input aaabbbcc ... Use heap for correct solution
public class RearrangeNotSameAdjacent {
	public static void rearrange(char[] s) throws Exception {
		int n = s.length;

		for (int i = 0; i < n - 1; i++) {
			int j = i + 1;
			while (j < n && s[i] == s[j]) {
				j++;
			}
			if (j < n)
				swap(s, i + 1, j);
		}
		// if last two chars are same it means we can't arrange
		if (s[n - 1] == s[n - 2])
			throw new Exception("Can't rearrange");
	}

	private static void swap(char[] s, int i, int j) {
		char temp = s[i];
		s[i] = s[j];
		s[j] = temp;
	}

	public static void main(String[] args) throws Exception {
		String s = "aaabbbcc";
		char[] arr = s.toCharArray();
		rearrange(arr);
		System.out.println(arr);

		System.out.println("----------------------------------");

		/*s = "aaaaabcd";
		arr = s.toCharArray();
		rearrange(arr);
		System.out.println(arr);*/
	}
}
